package rs.uns.ftn.acs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.model.Authority;



public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	Optional<Authority> findByName(String name);
}