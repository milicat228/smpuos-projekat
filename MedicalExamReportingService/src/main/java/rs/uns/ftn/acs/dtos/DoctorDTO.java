package rs.uns.ftn.acs.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import rs.uns.ftn.acs.model.Doctor;
import rs.uns.ftn.acs.model.Specialty;

public class DoctorDTO {
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
	private Specialty spec;
	private int numOfPatients;
	
	public int getNumOfPatients() {
		return numOfPatients;
	}

	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}

	public DoctorDTO() {
		
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

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
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

	public Specialty getSpec() {
		return spec;
	}

	public void setSpec(Specialty spec) {
		this.spec = spec;
	}

	public DoctorDTO(@NotBlank(message = "Korisničko ime je obavezno polje.") String username,
			@NotBlank(message = "Šifra je obavezno polje.") String password,
			@NotBlank(message = "Email je obavezno polje.") @Email(message = "Email treba da ima format example@mail.com.") String email,
			@NotNull(message = "Aktivnost naloga je obavezno polje.") Boolean active,
			@NotBlank(message = "Ime je obavezno polje.") String firstname,
			@NotBlank(message = "Prezime je obavezno polje.") String lastname,
			@NotBlank(message = "JMBG je obavezno polje.") @Length(min = 13, max = 13, message = "JMBG treba da ima 13 cifara.") String jMBG,
			Date dateOfBirth, String address, String phoneNumber, Specialty spec, int numOfPatients) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
		JMBG = jMBG;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.spec = spec;
		this.numOfPatients = numOfPatients;
	}
	public Doctor getDoc() {
		Doctor doc = new Doctor();
		doc.setActive(getActive());
		doc.setAddress(getAddress());
		doc.setEmail(getEmail());
		doc.setUsername(getUsername());
		doc.setPassword(getPassword());
		doc.setFirstname(getFirstname());
		doc.setLastname(getLastname());
		doc.setPhoneNumber(getPhoneNumber());
		doc.setSpec(getSpec());
		doc.setNumOfPatients(getNumOfPatients());
		
		return doc;
		
	}
	
	
	
}
