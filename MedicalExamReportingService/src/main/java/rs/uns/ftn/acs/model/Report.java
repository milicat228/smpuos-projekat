package rs.uns.ftn.acs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import rs.uns.ftn.acs.dtos.ReportDTO;


@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	private List<Allergy> allergies;
	
	@ManyToMany
	private List<FamilyDisease> familyDiseases;
	
	@Column
	private String opinion;
	
	@ManyToMany
	private List<DiagnosedDisease> diagnosedDiseases;
	
	@ManyToMany
	private List<Med> meds;
	
	@Column
	private String therapyDescription;
	
	@ManyToOne
	@JoinColumn(name="idDoc")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="idPat")
	private Patient patient;

	public Report() {
		super();
	}

	public Report(Integer id, List<Allergy> allergies, List<FamilyDisease> familyDisaeases, String opinion,
			List<DiagnosedDisease> diagnosedDisaeases, List<Med> meds, String therapyDescription, Doctor doctor,
			Patient patient) {
		super();
		this.id = id;
		this.allergies = allergies;
		this.familyDiseases = familyDisaeases;
		this.opinion = opinion;
		this.diagnosedDiseases = diagnosedDisaeases;
		this.meds = meds;
		this.therapyDescription = therapyDescription;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public List<FamilyDisease> getFamilyDiseases() {
		return familyDiseases;
	}

	public void setFamilyDiseases(List<FamilyDisease> familyDisaeases) {
		this.familyDiseases = familyDisaeases;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public List<DiagnosedDisease> getDiagnosedDiseases() {
		return diagnosedDiseases;
	}

	public void setDiagnosedDiseases(List<DiagnosedDisease> diagnosedDiseases) {
		this.diagnosedDiseases = diagnosedDiseases;
	}

	public List<Med> getMeds() {
		return meds;
	}

	public void setMeds(List<Med> meds) {
		this.meds = meds;
	}

	public String getTherapyDescription() {
		return therapyDescription;
	}

	public void setTherapyDescription(String therapyDescription) {
		this.therapyDescription = therapyDescription;
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
