package rs.uns.ftn.acs.dto.authentication.nurseDTO;

import javax.validation.constraints.NotNull;

public class ProfessionalQualification {	
	private Integer id;	
	private String name;
	private String description;

	@NotNull(message = "Oznaka kvalifikacije je obavezno polje.")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
