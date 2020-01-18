package rs.uns.ftn.acs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	@Id
	private Integer id;
	
	//Licne informacije
	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false, unique = true, length = 13)
	private String JMBG;

	@Column
	private Date dateOfBirth;
	
	@Column
	private Gender gender;
	
	//Informacije o osiguranju
	
	@Column(nullable = false, unique = true, length = 11)
	private String LBO;
	
	@ManyToOne
	private InsurenceBase insurenceBase;
	
	@ManyToOne
	private InsurencePayer insurencePayer;
	
	@Column
	private Date insurenceEndDate;
	
	//Konktakt informacije

	@Column
	private String adress;

	@Column
	private String phoneNumber;
}
