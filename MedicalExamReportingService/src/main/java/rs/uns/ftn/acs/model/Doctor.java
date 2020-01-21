package rs.uns.ftn.acs.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends UserAccount {
	

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column(unique = true, length = 13)
	private String JMBG;

	@Column
	private Date dateOfBirth;

	@Column
	private String address;

	@Column
	private String phoneNumber;

	@Column
	private Specialty spec;

	@Column
	private int numOfPatients;
	
	/*@OneToMany(fetch=FetchType.LAZY, mappedBy = "doctor")
	private List<Report> reports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "doctor")
	private List<Appointment> appointments;*/

	public Doctor() {
		super();
	}

	
/*
	public Doctor(Integer idDoc, String firstname, String lastname, String jMBG, String email, String username,
			String password, Date dateOfBirth, String address, String phoneNumber, Specialty spec, int numOfPatients,
			Timestamp lastPasswordChangeDate, Boolean active, Date registrationDate, List<Report> reports,
			List<Appointment> appointments) {
		super();
		this.idDoc = idDoc;
		this.firstname = firstname;
		this.lastname = lastname;
		this.JMBG = jMBG;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.spec = spec;
		this.numOfPatients = numOfPatients;
		this.lastPasswordChangeDate = lastPasswordChangeDate;
		this.active = active;
		this.registrationDate = registrationDate;
		this.reports = reports;
		this.appointments = appointments;
	}
*/

/*
	public Integer getId() {
		return idDoc;
	}

	public void setId(Integer id) {
		this.idDoc = id;
	}
*/
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
/*
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

*/	public Date getDateOfBirth() {
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

	public int getNumOfPatients() {
		return numOfPatients;
	}

	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}
/*
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

*/

	/*public List<Report> getReports() {
		return reports;
	}



	public void setReports(List<Report> reports) {
		this.reports = reports;
	}



	public List<Appointment> getAppointments() {
		return appointments;
	}

	

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	*/
	/*@ManyToMany(fetch = FetchType.EAGER)
	protected Set<Authority> authorities;*/

	

	
	

}
