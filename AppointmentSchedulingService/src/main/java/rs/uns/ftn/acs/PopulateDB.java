package rs.uns.ftn.acs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import rs.uns.ftn.acs.models.Doctor;
import rs.uns.ftn.acs.models.DoctorType;
import rs.uns.ftn.acs.models.Patient;
import rs.uns.ftn.acs.repositories.DoctorRepository;
import rs.uns.ftn.acs.repositories.PatientRepository;

@Component
public class PopulateDB implements ApplicationRunner{

	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	PasswordEncoder enc;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {		
		if(doctorRepo.findAll().isEmpty()) {
			Doctor doctor = new Doctor();
			doctor.setFirstname("Doctor1");
			doctor.setLastname("lastname");
			doctor.setDoctorType(DoctorType.OPSTA_PRAKSA);
			doctorRepo.save(doctor);
			
			Patient patient = new Patient();
			patient.setFirstname("Patient1");
			patient.setLastname("Lastname1");
			patient.setAddress("Adress1");
			patient.setEmail("email1@gamil.com");
			patient.setUsername("username1");
			patient.setPassword(enc.encode("password1"));
			patient.setDoctor(doctor);
			patientRepo.save(patient);
			
			
			
		}
		
	}
	
	
	
}
