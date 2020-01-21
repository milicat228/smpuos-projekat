package rs.uns.ftn.acs.service.patient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.entity.Patient;
import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;
import rs.uns.ftn.acs.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	/**
	 * Find patient with lbo. 
	 * @param lbo
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Patient findByLBO(String lbo) throws ResourceNotFoundException {
		Optional<Patient> optionalPatient = patientRepository.findByLBO(lbo);
		if (optionalPatient.isPresent()) {
			return optionalPatient.get();
		}
		throw new ResourceNotFoundException(lbo);
	}
}
