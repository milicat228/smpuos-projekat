package rs.uns.ftn.acs.service.patient;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.repository.PatientRepository;
import rs.uns.ftn.acs.service.crud.CRUDService;
import rs.uns.ftn.acs.service.rfzo.RFZOService;

@Service
public class PatientService extends CRUDService<Patient, Integer> {
	@Autowired
	private RFZOService rfzoService;
	
	public PatientService(PatientRepository repo) {
		super(repo);
	}

	/**
	 * Find patient with lbo.
	 * 
	 * @param lbo
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Patient findByLBO(String lbo) throws ResourceNotFoundException {
		Optional<Patient> optionalPatient = ((PatientRepository) repo).findByLBO(lbo);
		if (optionalPatient.isPresent()) {
			return checkInsuranceDate(optionalPatient.get());
		}
		throw new ResourceNotFoundException(lbo);
	}

	public Patient checkInsuranceDate(Patient patient) {
		Date date = rfzoService.getInsurenceEndDate(patient.getLBO(), patient.getZK(), patient.getInsurenceEndDate(), true);
		if (date != null) {
			patient.setInsurenceEndDate(date);
			save(patient);
		}
		return	patient;
	}
	
	public Patient findById(int id) throws ResourceNotFoundException {
		Optional<Patient> optionalPatient=((PatientRepository) repo).findById(id);
		if (optionalPatient.isPresent()) {
			return optionalPatient.get();
		}
		throw new ResourceNotFoundException(id+"");
	}
}
