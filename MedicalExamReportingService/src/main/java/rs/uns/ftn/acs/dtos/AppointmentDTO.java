package rs.uns.ftn.acs.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import rs.uns.ftn.acs.model.Doctor;
import rs.uns.ftn.acs.model.Patient;

public class AppointmentDTO {
	

	private int idApp;
	private Timestamp dateAndTime;
	private int duration;
	private Boolean free;
	private Boolean came;
	private int docId;
	private int patId;
	
	public AppointmentDTO(int idApp, Timestamp dateAndTime, int duration, Boolean free, Boolean came, int docId,
			int patId) {
		super();
		this.idApp = idApp;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.free = free;
		this.came = came;
		this.docId = docId;
		this.patId = patId;
	}

	public int getIdApp() {
		return idApp;
	}

	public void setIdApp(int idApp) {
		this.idApp = idApp;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	public Boolean getCame() {
		return came;
	}

	public void setCame(Boolean came) {
		this.came = came;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getPatId() {
		return patId;
	}

	public void setPatId(int patId) {
		this.patId = patId;
	}
	
	

}
