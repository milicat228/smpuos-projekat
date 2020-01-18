package rs.uns.ftn.acs.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nurse_id_generator")
	@SequenceGenerator(name = "nurse_id_generator", sequenceName = "nurse_id_generator_seq")
	protected Integer id;

	@Column(unique = true, nullable = false)
	protected String username;

	@JsonIgnore
	@Column(nullable = false)
	protected String password;

	@JsonIgnore
	@Column
	protected Timestamp lastPasswordChangeDate;

	@Column(unique = true, nullable = false)
	protected String email;

	@Column(nullable = false)
	protected Boolean active = true;

	@CreationTimestamp
	protected Date registrationDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	protected Set<Authority> authorities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.lastPasswordChangeDate = new Timestamp(System.currentTimeMillis());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	@JsonIgnore
	public Set<Authority> getUserAuthorities() {
		if (authorities == null) {
			authorities = new HashSet<>();
		}
		return authorities;
	}

	public Timestamp getLastPasswordChangeDate() {
		return lastPasswordChangeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
