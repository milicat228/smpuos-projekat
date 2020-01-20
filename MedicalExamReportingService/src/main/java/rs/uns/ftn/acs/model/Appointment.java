package rs.uns.ftn.acs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.sql.Timestamp;

@Entity
public class Appointment {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idApp;
	
	@Column 
	private Timestamp dateAndTime;
	
	@Column
	private Integer duration;
	
	@Column
	private Boolean free;
	
	@ManyToOne
	@JoinColumn(name="idDoc")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="idPat")
	private Patient patient;

	public Appointment() {
		super();
	}

	public Appointment(Integer idApp, Timestamp dateAndTime, Integer duration, Boolean free, Doctor doctor,
			Patient patient) {
		super();
		this.idApp = idApp;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.free = free;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getIdApp() {
		return idApp;
	}

	public void setIdApp(Integer idApp) {
		this.idApp = idApp;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
