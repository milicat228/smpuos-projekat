package rs.uns.ftn.acs.dto.patient;

import java.util.List;

public class AppointmentsDTO {
	private Boolean patientBlocked;
	private List<AppointmentDTO> appointments;

	public AppointmentsDTO() {
		super();
	}

	public AppointmentsDTO(Boolean patientBlocked, List<AppointmentDTO> appointments) {
		super();
		this.patientBlocked = patientBlocked;
		this.appointments = appointments;
	}

	public Boolean getPatientBlocked() {
		return patientBlocked;
	}

	public void setPatientBlocked(Boolean patientBlocked) {
		this.patientBlocked = patientBlocked;
	}

	public List<AppointmentDTO> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentDTO> appointments) {
		this.appointments = appointments;
	}
}
