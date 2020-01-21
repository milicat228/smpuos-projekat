package rs.uns.ftn.acs.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Patient { 
		@Column(unique = true, nullable = false)
		private String username;
		
		@JsonIgnore
		@Column(nullable = false)
		private String password;
		 	
	 	@Column
		private String firstname;

		@Column
		private String lastname;
			
		@Column
		private Date birthday;
		
		@Column
		private String address;

		@Column
		private String phone;
		
		@Column
		protected Timestamp lastPasswordChangeDate;

		@Column(unique = true, nullable = false)
		protected String email;

		@Column(nullable = false)
		protected Boolean active = true;

		@CreationTimestamp
		protected Date registrationDate;
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_patient")
		@SequenceGenerator(name = "patient_id_generator", sequenceName = "generatorseq_patient")
		protected Integer id;
		
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
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Timestamp getLastPasswordChangeDate() {
			return lastPasswordChangeDate;
		}

		public void setLastPasswordChangeDate(Timestamp lastPasswordChangeDate) {
			this.lastPasswordChangeDate = lastPasswordChangeDate;
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

		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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
			Patient other = (Patient) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
}