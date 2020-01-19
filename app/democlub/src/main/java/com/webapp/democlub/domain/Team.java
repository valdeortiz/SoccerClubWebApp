package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String division;
	private String name;
	private Integer salary_prom;
	
	@OneToMany(mappedBy="team",cascade = CascadeType.ALL)
	private List<Jugador> jugadores;
	
	public Team() {
		jugadores = new ArrayList<>();
	}
	public void addJugador(Jugador jugador) {
		if (!jugadores.contains(jugador)) {
			jugadores.add(jugador);
			jugador.setTeam(this);
		}
		
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
		for(Jugador i : jugadores) {
			addJugador(i);
		}
		this.jugadores = jugadores;
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
