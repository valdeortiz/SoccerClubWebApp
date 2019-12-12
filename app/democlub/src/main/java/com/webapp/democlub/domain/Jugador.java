package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jugador extends Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hability;
	private Integer trophies_number;
	private String position;
	public Integer getHability() {
		return hability;
	}

	public void setHability(Integer hability) {
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
