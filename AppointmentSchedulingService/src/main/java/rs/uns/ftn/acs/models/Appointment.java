package rs.uns.ftn.acs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	public String asdf;
	
	
}
