package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Organization{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type = "Ong"; // por ahora solo aceptamos ong en un futuro podriamos expandir
	private String name;
	private Integer yearOld;
	private Double money;
	
	@ManyToMany(mappedBy = "orgs")
	List<Team> members = new ArrayList<>();

	
	public Double getMoney() {
		if (this.money == null) {
			return 0.0;
		}else {
			return money;
		}
	}
//	public void setMoney(Double money) {
//		this.money = money;
//	}
	public void addMoney(Double money) {
		if (this.money != null) {
			this.money += money;
		}else {
			this.money = money;
		}
		
	}
	public Integer getYearOld() {
		return yearOld;
	}
	public void setYearOld(Integer yearOld) {
		this.yearOld = yearOld;
	}
	public List<String> getMembers() {
		List<String> resul = new ArrayList<>();
		for (Team team : members) {
			resul.add(team.getName());
		}
		return resul;
	}
	public void addteam(Team nameTeam) {
		if (!members.contains(nameTeam)) {
			members.add(nameTeam);
		}else {
			System.err.println("Ya existe el equipo: " + nameTeam.getName());
		}
		
	}

	public void setMembers(List<Team> nameTeams) {
		for (Team team : nameTeams) {
			addteam(team);
		}
		//this.teams = teams;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
}
