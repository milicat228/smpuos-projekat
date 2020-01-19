package rs.uns.ftn.acs.dto.crud;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import rs.uns.ftn.acs.entity.Nurse;
import rs.uns.ftn.acs.entity.ProfessionalQualification;

public class NurseDTO {
	@NotBlank(message = "Korisničko ime je obavezno polje.")
	protected String username;
	@NotBlank(message = "Šifra je obavezno polje.")
	protected String password;
	@NotBlank(message = "Email je obavezno polje.")
	@Email(message = "Email treba da ima format example@mail.com.")
	protected String email;
	@NotNull(message = "Aktivnost naloga je obavezno polje.")
	protected Boolean active;
	@NotBlank(message = "Ime je obavezno polje.")
	private String firstname;
	@NotBlank(message = "Prezime je obavezno polje.")
	private String lastname;
	@NotBlank(message = "JMBG je obavezno polje.")
	@Length(min = 13, max = 13, message = "JMBG treba da ima 13 cifara.")
	private String JMBG;
	private Date dateOfBirth;
	private String address;
	private String phoneNumber;
	@NotNull(message = "Stručna sprema je obavezno polje.")
	private ProfessionalQualification professionalQualification;
	
	public Nurse getNurse() {
		Nurse ret = new Nurse();
		ret.setUsername(username);
		ret.setPassword(password);
		ret.setEmail(email);
		ret.setActive(active);
		ret.setFirstname(firstname);
		ret.setLastname(lastname);
		ret.setJMBG(JMBG);
		ret.setDateOfBirth(dateOfBirth);
		ret.setAddress(address);
		ret.setPhoneNumber(phoneNumber);
		ret.setProfessionalQualification(professionalQualification);
		return ret;
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

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String JMBG) {
		this.JMBG = JMBG;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ProfessionalQualification getProfessionalQualification() {
		return professionalQualification;
	}

	public void setProfessionalQualification(ProfessionalQualification professionalQualification) {
		this.professionalQualification = professionalQualification;
	}
}
