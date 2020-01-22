package rs.uns.ftn.acs.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import rs.uns.ftn.acs.entity.Gender;
import rs.uns.ftn.acs.entity.InsurenceBase;
import rs.uns.ftn.acs.entity.InsurencePayer;
import rs.uns.ftn.acs.entity.Patient;

public class PatientDTO {
	@NotBlank(message = "Ime je obavezno polje.")
	private String firstname;
	@NotBlank(message = "Prezime je obavezno polje.")
	private String lastname;
	private Date dateOfBirth;
	private Gender gender;
	private InsurenceBase insurenceBase;
	private InsurencePayer insurencePayer;
	private Date insurenceEndDate;
	private String address;
	private String phoneNumber;
	@NotBlank(message = "LBO je obavezno polje.")
	@Length(min = 11, max = 11, message = "LBO treba da ima 11 cifara.")
	private String LBO;
	@NotBlank(message = "ZK je obavezno polje.")
	@Length(min = 11, max = 11, message = "ZK treba da ima 11 cifara.")
	private String ZK;
	@NotBlank(message = "JMBG je obavezno polje.")
	@Length(min = 13, max = 13, message = "JMBG treba da ima 13 cifara.")
	private String JMBG;
	
	public Patient getPatient() {
		Patient pat = new Patient();
		pat.setFirstname(firstname);
		pat.setLastname(lastname);
		pat.setDateOfBirth(dateOfBirth);
		pat.setGender(gender);
		pat.setInsurenceBase(insurenceBase);
		pat.setInsurencePayer(insurencePayer);
		pat.setInsurenceEndDate(insurenceEndDate);
		pat.setAddress(address);
		pat.setPhoneNumber(phoneNumber);
		pat.setLBO(LBO);
		pat.setZK(ZK);
		pat.setJMBG(JMBG);
		return pat;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String lBO) {
		LBO = lBO;
	}

	public String getZK() {
		return ZK;
	}

	public void setZK(String zK) {
		ZK = zK;
	}

	public InsurenceBase getInsurenceBase() {
		return insurenceBase;
	}

	public void setInsurenceBase(InsurenceBase insurenceBase) {
		this.insurenceBase = insurenceBase;
	}

	public InsurencePayer getInsurencePayer() {
		return insurencePayer;
	}

	public void setInsurencePayer(InsurencePayer insurencePayer) {
		this.insurencePayer = insurencePayer;
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

	public Date getInsurenceEndDate() {
		return insurenceEndDate;
	}

	public void setInsurenceEndDate(Date insurenceEndDate) {
		this.insurenceEndDate = insurenceEndDate;
	}
	
	
 
}
