package rs.uns.ftn.acs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.model.UserAccount;



public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
	Optional<UserAccount> findByUsername(String username);
}
