package rs.uns.ftn.acs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang.time.DateUtils;

@Entity
@DiscriminatorValue("patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
	@SequenceGenerator(name = "patient_generator", sequenceName = "patient_seq", initialValue = 50)
	private Integer id;
	
	//Licne informacije
	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false, unique = true, length = 13)
	private String JMBG;

	@Column
	private Date dateOfBirth;
	
	@Column
	private Gender gender;
	
	//Informacije o osiguranju
	
	@Column(nullable = false, unique = true, length = 11)
	private String LBO;
	
	@Column(nullable = false, unique = true, length = 11)
	private String ZK;
	
	@ManyToOne
	private InsurenceBase insurenceBase;
	
	@ManyToOne
	private InsurencePayer insurencePayer;
	
	@Column
	private Date insurenceEndDate;
	
	//Konktakt informacije

	@Column
	private String address;

	@Column
	private String phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setZK(String ZK) {
		this.ZK = ZK;
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

	public Date getInsurenceEndDate() {
		return insurenceEndDate;
	}
	
	public Boolean isInsurenceValid() {
		if(this.insurenceEndDate == null) {
			return false;
		}
		Date now = new Date();
		
		//vrati true ako je isti dan
		if( DateUtils.isSameDay(now, this.insurenceEndDate)) {
			return true;
		}
		
		//vrati true ako je u buducnosti
		if( this.insurenceEndDate.after(now) ) {
			return true;
		}
		
		return false;
	}

	public void setInsurenceEndDate(Date insurenceEndDate) {
		this.insurenceEndDate = insurenceEndDate;
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
}
