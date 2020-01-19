package rs.uns.ftn.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.entity.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {

}
