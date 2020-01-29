package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String type;
	
	@OneToMany(mappedBy="tournament")
	private List<Team> teams;
	
	public Tournament() {
		teams = new ArrayList<>();
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	public void addTeam(Team team) {
		if (!teams.contains(team)) {
			teams.add(team);
			team.setTournament(this);
		}
	}

	public void setTeams(List<Team> teams) {
		for(Team i : teams) {
			addTeam(i);
		}
		this.teams = teams;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
 