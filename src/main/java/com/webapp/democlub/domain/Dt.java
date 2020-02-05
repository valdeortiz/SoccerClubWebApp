package com.webapp.democlub.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Dt extends Player{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "dt", fetch = FetchType.LAZY)
	private Team team;
	//private Integer trophies;
	
	
	public String getTeam() {
		if (team != null) {
			return team.getName();
		}else {
			return "no team";
		}
	}
	public Team teamObj() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public void setProfession(String profession) {
		profession = "dt";
		super.setProfession(profession);
	}
	
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
