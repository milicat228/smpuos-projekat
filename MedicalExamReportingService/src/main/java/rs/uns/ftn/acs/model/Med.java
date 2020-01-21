package rs.uns.ftn.acs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Med {
	
	@Id
	private Integer id;
	
	@Column
	private String name;
	
	

	public Med() {
		super();
	}

	public Med(Integer id, String name) {
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
