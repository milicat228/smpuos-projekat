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
	private Integer id;
	
	@Column 
	private Timestamp dateAndTime;
	
	@Column
	private Integer duration;
	
	@Column
	private Boolean free=true;
	
	@Column
	private Boolean came;
	
	@ManyToOne
	@JoinColumn(name="idDoc")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="idPat")
	private Patient patient;

	public Appointment() {
		super();
	}

	public Appointment(Integer id, Timestamp dateAndTime, Integer duration, Boolean free, Doctor doctor,
			Patient patient,Boolean came) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.free = free;
		this.doctor = doctor;
		this.patient = patient;
		this.came=came;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getCame() {
		return came;
	}

	public void setCame(Boolean came) {
		this.came = came;
	}
	
	
}
