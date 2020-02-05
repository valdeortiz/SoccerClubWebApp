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
	private String winner;
	
	@OneToMany(mappedBy="tournament")
	private List<Team> teams;
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Tournament() {
		teams = new ArrayList<>();
	}
	
	public List<String> getTeamsName() {
		List<String> resul = new ArrayList<>();
		for (Team team : teams) {
			resul.add(team.getName());
		}
		return resul;
	}
	public List<Team> Teams() {
		return teams;
	}
	public void addTeam(Team team) {
		if (!teams.contains(team)) {
			teams.add(team);
			team.setTournament(this);
			System.err.println("Se agrego el equipo");
		}else {
			System.err.println("Ya existe el equipo en el torneo ");
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
 