package rs.uns.ftn.acs.dtos;

import java.util.ArrayList;

import rs.uns.ftn.acs.model.Allergy;
import rs.uns.ftn.acs.model.DiagnosedDisease;
import rs.uns.ftn.acs.model.FamilyDisease;
import rs.uns.ftn.acs.model.Med;

public class ReportDTO {
	
	private int id;
	private ArrayList<Allergy> allergies;
	private ArrayList<DiagnosedDisease> diagnosedDiseases;
	private ArrayList<FamilyDisease> familyDiseases;
	private String opinion;
	private String therapyDescription;
	private ArrayList<Med> meds;
	private int docId;
	private int patId;
	
	public ReportDTO(int id, ArrayList<Allergy> allergies, ArrayList<DiagnosedDisease> diagnosedDiseases,
			ArrayList<FamilyDisease> familyDiseases, String opinion, String therapyDescription, ArrayList<Med> meds,
			int docId, int patId) {
		super();
		this.id = id;
		this.allergies = allergies;
		this.diagnosedDiseases = diagnosedDiseases;
		this.familyDiseases = familyDiseases;
		this.opinion = opinion;
		this.therapyDescription = therapyDescription;
		this.meds = meds;
		this.docId = docId;
		this.patId = patId;
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

	public ReportDTO () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(ArrayList<Allergy> allergies) {
		this.allergies = allergies;
	}

	public ArrayList<DiagnosedDisease> getDiagnosedDiseases() {
		return diagnosedDiseases;
	}

	public void setDiagnosedDiseases(ArrayList<DiagnosedDisease> diagnosedDiseases) {
		this.diagnosedDiseases = diagnosedDiseases;
	}

	public ArrayList<FamilyDisease> getFamilyDiseases() {
		return familyDiseases;
	}

	public void setFamilyDiseases(ArrayList<FamilyDisease> familyDiseases) {
		this.familyDiseases = familyDiseases;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getTherapyDescription() {
		return therapyDescription;
	}

	public void setTherapyDescription(String therapyDescription) {
		this.therapyDescription = therapyDescription;
	}

	public ArrayList<Med> getMeds() {
		return meds;
	}

	public void setMeds(ArrayList<Med> meds) {
		this.meds = meds;
	}
	
	
	
	

}
