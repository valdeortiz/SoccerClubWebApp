package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Executive extends Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Override
	public void setProfession(String profession) {
		// TODO Auto-generated method stub
		profession = "Directivo";
		super.setProfession(profession);
	}
	
	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "directivo";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
		
	
}
