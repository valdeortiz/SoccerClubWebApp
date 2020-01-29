package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.repository.TeamRepository;
import com.webapp.democlub.repository.TournamentRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
		
	public Team findById(Long id) {
		Team team = teamRepository.findById(id).orElse(null);
		return team;
	}
	public List<Team> findByDivision(String div) {
		List<Team> team = teamRepository.findByDivision(div);
		return team;
	}
	public List<String> average(String name) {
		Team team = teamRepository.findByName(name);
		List<Player> playes = team.getPlayers();
		List<String> resul = new ArrayList<>();
		resul.add("Nombre : salario promedio");
		resul.add("Equipo: " + team.getName() + ": " + team.getSalaryAv());
		for (Player player : playes) {
			resul.add(player.getFirstName() + " " + player.getLastName() + ": " + player.getAverage_salary());
		}
		resul.add(team.DtObj().getFirstName() + " " + team.DtObj().getLastName() + ": " + team.DtObj().getAverage_salary());
		return resul;
	}

	
	public List<Team> findAll() {
		List<Team> teams = new ArrayList<>();
		Iterator<Team> iteratorTeams = teamRepository.findAll().iterator();
		while (iteratorTeams.hasNext()) {
			teams.add(iteratorTeams.next());
		}
		return teams;
	}
	
	public void save(Team team)throws InscripcionException {
		//int cont = 0;
//		for (Player player : this.getPlayers() ) {
//			if(player.getId() == dt.getId() ) {
//			//	cont = 1;
//				System.out.println("Existe el dt en el team");
//			}
//		}
//		if (dt.getTrophies_number() < 1) {
//			InscripcionException inscripcionException =  new InscripcionException(
//					"No se permite la inscripción para jugadores con menos de 1 titulo ganado con el club: " + dt.getTrophies_number());
//			inscripcionException.setContacto("contacto@gmail.com");
//		}
		Tournament tourn = tournamentRepository.findByName(team.getTournament());
		Team equipo = teamRepository.findByName(team.getName());
				
		if (tourn == null || equipo != null) {
			InscripcionException inscripcionException =  new InscripcionException(
					"Asegurese de que escribio correctamente el TORNEO o que el nombre del equipo no existe: ");
			inscripcionException.setContacto("contacto@gmail.com");
			System.err.println("tourn o equipo es null");
			
		}else {
			tourn.addTeam(team);
			team.setTournament(tourn);
			teamRepository.save(team);
		}
		
	}

	public void delete(Long id) {
		teamRepository.deleteById(id);
	}

	public void deleteAll() {
		teamRepository.deleteAll();
	}

}
