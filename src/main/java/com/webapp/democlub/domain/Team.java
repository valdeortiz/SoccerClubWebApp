package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String division;
	private String name;
	private Integer salary_prom;
	
	@OneToMany(mappedBy="team",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Player> players;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="dt_id")
	private Dt dt;
		
	
	public void setDt(Dt dt) {
		dt.setTeam(this);
		this.dt = dt;
	}
	
	public String getDt() {
		if (dt != null) {
			return dt.getFirstName();
		}else {
			return "no name";
		}
		
	}
	
	public String getTournament() {
		if(tournament != null) {
			return tournament.getName();	
		}else {
			return "not tournament";
		}
		
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
//*********************************************************
	public Team() {
		players = new ArrayList<>();
	}
	
	private void addPlayer(Player player) {
		if (!players.contains(player)) {
			players.add(player);
			player.setTeam(this);
		}	
	}
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		for(Player i : players) {
			addPlayer(i);
		}
		this.players = players;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void setDivision(String division){
		this.division = division;
	}
	
	public String getDivision(){
		return division;
	}

	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}

	public Integer getSalary_prom() {
		return salary_prom;
	}

	public void setSalary_prom(Integer salary_prom) {
		this.salary_prom = salary_prom;
	}

	
}
