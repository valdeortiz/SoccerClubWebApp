package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Team;
import com.webapp.democlub.domain.Tournament;
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

	
	public List<Team> findAll() {
		List<Team> teams = new ArrayList<>();
		Iterator<Team> iteratorTeams = teamRepository.findAll().iterator();
		while (iteratorTeams.hasNext()) {
			teams.add(iteratorTeams.next());
		}
		return teams;
	}
	
	public void save(Team team) {
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
		if (tourn != null) {
			tourn.addTeam(team);
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
