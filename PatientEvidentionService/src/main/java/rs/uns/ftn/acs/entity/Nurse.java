package rs.uns.ftn.acs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("nurse")
public class Nurse extends UserAccount {

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column(unique = true, length = 13)
	private String JMBG;

	@Column
	private Date dateOfBirth;

	@Column
	private String adress;

	@Column
	private String phoneNumber;

	@ManyToOne
	@JoinColumn
	private ProfessionalQualification professionalQualification;

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
