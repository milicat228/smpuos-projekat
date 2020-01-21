package rs.uns.ftn.acs.dto.patient;

import java.util.Date;

public class AppointmentDTO {
	private Integer id;
	private Date date;
	private Integer duration;
	private String doctorName;
	private Boolean patientArrivedOnTime = false;
	private AppointmentStatus status;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(Integer id, Date date, Integer duration, String doctorName, Boolean patientArrivedOnTime) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.doctorName = doctorName;
		this.patientArrivedOnTime = patientArrivedOnTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Boolean getPatientArrivedOnTime() {
		return patientArrivedOnTime;
	}

	public void setPatientArrivedOnTime(Boolean patientArrivedOnTime) {
		this.patientArrivedOnTime = patientArrivedOnTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
}
