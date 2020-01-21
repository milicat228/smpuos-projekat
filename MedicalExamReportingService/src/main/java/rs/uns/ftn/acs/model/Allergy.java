package rs.uns.ftn.acs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Allergy {
	
	@Id
	private Integer id;
	
	@Column
	private String name;
	/*
	@ManyToMany
	private List<Report> reports;
	*/
	public Allergy() {
		super();
	}

	public Allergy(Integer id, String name/*, List<Report> reports*/) {
		super();
		this.id = id;
		this.name = name;
		//this.reports = reports;
	}

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
/*
	public List<Report> getPatients() {
		return reports;
	}

	public void setPatients(List<Report> reports) {
		this.reports = reports;
	}
*/
}
