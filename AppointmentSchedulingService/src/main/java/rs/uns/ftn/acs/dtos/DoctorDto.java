package rs.uns.ftn.acs.dtos;

import rs.uns.ftn.acs.models.Doctor;
import rs.uns.ftn.acs.models.DoctorType;

public class DoctorDto {
	
	private long id;
	private String firstname;
	private String lastname;
	private DoctorType doctor;
	
	public DoctorDto(Doctor d) {
		id = d.getId();
		firstname = d.getFirstname();
		lastname = d.getLastname();
		doctor = d.getDoctorType();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public DoctorType getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorType doctor) {
		this.doctor = doctor;
	}
	
	
}
