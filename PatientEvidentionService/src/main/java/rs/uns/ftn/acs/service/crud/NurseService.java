package rs.uns.ftn.acs.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.uns.ftn.acs.entity.Authority;
import rs.uns.ftn.acs.entity.Nurse;
import rs.uns.ftn.acs.repository.NurseRepository;

@Service
public class NurseService extends CRUDService<Nurse, Integer>{
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthorityService authorityService;

	public NurseService(NurseRepository repo) {
		super(repo);
	}
	
	@Override
	public Nurse save(Nurse entity) {
		entity.setPassword(encoder.encode(entity.getPassword()));
		Authority authority = authorityService.findByName("NURSE");
		entity.getUserAuthorities().add(authority);
		return super.save(entity);
	}
	
}
