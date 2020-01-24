package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dt extends Player{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Override
	public void setProfession(String profession) {
		profession = "dt";
		super.setProfession(profession);
	}
	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "Dt";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
