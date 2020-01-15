package rs.uns.ftn.acs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MedicalExamReportingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalExamReportingServiceApplication.class, args);
	}

}
