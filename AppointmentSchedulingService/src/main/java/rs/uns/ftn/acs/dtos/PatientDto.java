package rs.uns.ftn.acs.dtos;


	import java.util.Date;

	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;

	import org.hibernate.validator.constraints.Length;

import rs.uns.ftn.acs.models.Doctor;
import rs.uns.ftn.acs.models.DoctorType;
import rs.uns.ftn.acs.models.Patient;

	public class PatientDto {
		@NotBlank(message = "Email is requested.")
		protected String email;
		protected Boolean active;
		private String firstname;
		private String lastname;
		private Date birthday;
		private String address;
		private String phone;
		private String username;
		private String password;
		private Integer id;
		private Doctor doctor;
		
		public Patient getPatient() {
			Patient patient = new Patient();
			patient.setUsername(username);
			patient.setPassword(password);
			patient.setEmail(email);
			patient.setFirstname(firstname);
			patient.setLastname(lastname);
			patient.setBirthday(birthday);
			patient.setAddress(address);
			patient.setPhone(phone);
			patient.setId(id);
			patient.setDoctor(doctor);

			return patient;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String email) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String email) {
			this.password = password;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	
	}

