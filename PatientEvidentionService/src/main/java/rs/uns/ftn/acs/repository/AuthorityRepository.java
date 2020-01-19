package rs.uns.ftn.acs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	Optional<Authority> findByName(String name);
}