package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Jugador extends Employee{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer hability; /* 0 - 100% */
	private Integer trophies_number;
	private String position;
	private Integer average_salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "player";
	}
	@Override
	public void setProfession(String profession) {
		profession = "player";
		super.setProfession(profession);
	}
	
	public String getTeam() {
		return team.getName();
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Integer getHability() {
		return hability;
	}

	public void setHability(Integer hability) {
		this.hability = hability;
	}

	public Integer getTrophies_number() {
		return trophies_number;
	}
	public void setTrophies_number(Integer trophies_number) {
		this.trophies_number = trophies_number;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getAverage_salary() {
		return average_salary;
	}

	public void setAverage_salary(Integer average_salary) {
		this.average_salary = average_salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
