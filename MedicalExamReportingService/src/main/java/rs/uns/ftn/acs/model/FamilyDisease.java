package rs.uns.ftn.acs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class FamilyDisease {
	
	@Id
	private Integer id;
	
	@Column
	private String name;

	
	
	public FamilyDisease() {
		super();
	}

	public FamilyDisease(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		
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
	


}
