package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jugador extends Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String hability;
	private Integer trophies_number;
	
	public String getHability() {
		return hability;
	}

	public void setHability(String hability) {
		this.hability = hability;
	}
	public Integer getTrophies() {
		return trophies_number;
	}

	public void setTrophies(Integer trophies_number) {
		this.trophies_number = trophies_number;
	}
	

	@Override
	public String toString() {
		return "Trophies number: " + trophies_number + " Hability: " + hability;
	}

	
}
