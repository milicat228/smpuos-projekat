package rs.uns.ftn.acs.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.entity.ProfessionalQualification;
import rs.uns.ftn.acs.repository.ProfessionalQualificationRepository;

@Service
public class ProfessionalQualificationService extends CRUDService<ProfessionalQualification, Integer>{
	@Autowired
	public ProfessionalQualificationService(ProfessionalQualificationRepository repo) {
		super(repo);
	}
}
