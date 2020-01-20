package rs.uns.ftn.acs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	private Integer idPat;
	
	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column(unique = true, length = 13)
	private String JMBG;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "patient")
	private List<Report> reports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "patient")
	private List<Appointment> appointments;

	public Patient() {
		super();
	}

	

	public Patient(Integer idPat, String firstname, String lastname, String jMBG, List<Report> reports,		List<Appointment> appointments) {
		super();
		this.idPat = idPat;
		this.firstname = firstname;
		this.lastname = lastname;
		JMBG = jMBG;
		this.reports = reports;
		this.appointments = appointments;
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



	public Integer getIdPat() {
		return idPat;
	}

	public void setIdPat(Integer idPat) {
		this.idPat = idPat;
	}

	public List<Report> getReports() {
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
	
	
	
}
