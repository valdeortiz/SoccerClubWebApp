package com.webapp.democlub.domain;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
/*
* Modelamos cada uno de nuestros objetos a ser utilizado.
*
*/



@Entity
public class Directivo extends Employee{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	
	private String profession = "directivo";
	
	public void setProfession() {
		// TODO Auto-generated method stub
		super.setProfession(profession);
	}
		
	
}
