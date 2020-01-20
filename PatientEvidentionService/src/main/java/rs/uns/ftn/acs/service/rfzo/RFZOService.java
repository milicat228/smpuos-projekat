package rs.uns.ftn.acs.service.rfzo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RFZOService {
	private RestTemplate restTemplate = new RestTemplate();
	private Logger logger = LoggerFactory.getLogger(RFZOService.class);
	private static final String RFZOUrl = "http://rfzo.rs/proveraUplateDoprinosa2.php";

	public Date getInsurenceEndDate(String LBO, String ZK, Date knownInsurenceEndDate, Boolean checkDate) {
		// proveri da li je trenutno poznati datum posle danasnjeg
		Date currentDate = new Date();
		if (knownInsurenceEndDate != null) {
			if (currentDate.before(knownInsurenceEndDate) && checkDate) {
				return null; //nema potrebe da se proveri insurence end date, jer po onom u bazi jos vazi
			}
		}
		Date date = checkInsurenceEndDate(LBO, ZK);
		return date;
	}

	@HystrixCommand(fallbackMethod = "checkInsurenceEndDateFallback")
	private Date checkInsurenceEndDate(String LBO, String ZK) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// form values
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("zk", ZK);
		map.add("lbo", LBO);
		//send request
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(RFZOUrl, request, String.class);
		//parse response
		String responseString = response.getBody();		
		
		String dateString = responseString.subSequence(responseString.length() - 20, responseString.length() - 9).toString();
		return parseDate(dateString);
	}

	@SuppressWarnings("unused")
	private Date checkInsurenceEndDateFallback() {
		logger.info("RFZO ne odgovara.");
		return null;
	}

	private Date parseDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
		try {
			Date date = formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
}
