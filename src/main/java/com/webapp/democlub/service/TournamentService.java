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
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	
	public void insTourn(String name, String tourn) {
		Team team = teamRepository.findByName(name);
		Tournament tourna = tournamentRepository.findByName(tourn);
		if (team != null && tourna != null) {
			if (tourna.getType().equals("internacional") && team.getTournamentPosicion().equals(1)) {
				tourna.addTeam(team);
				//team.setTournament(tourna);
				teamRepository.save(team);
			}else if (tourna.getType() != "internacional") {
				tourna.addTeam(team);
				//team.setTournament(tourna);
				teamRepository.save(team);
			}else {
				System.err.println("El equipo no es campeon");
			}
		}else {
			System.err.println("No existe el equipo o el torneo");
		}
	}
	
	public Tournament findById(Long id) {
		Tournament tournament = tournamentRepository.findById(id).orElse(null);
		return tournament;
	}
	public List<Team> findByType(String type) {
		List<Team> teams = tournamentRepository.findByType(type).Teams();
		return teams;
	}
	public List<String> average(String name) {
		List<Team> teams = tournamentRepository.findByName(name).Teams();
		List<String> ave = new ArrayList<>();
		for (Team team : teams) {
			ave.add(team.getName() + ": " + team.getSalary_average());
		}
		return ave;
	}
	
	public List<Tournament> findAll() {
		List<Tournament> tournaments = new ArrayList<>();
		Iterator<Tournament> iteratorTournaments = tournamentRepository.findAll().iterator();
		while (iteratorTournaments.hasNext()) {
			tournaments.add(iteratorTournaments.next());
		}
		return tournaments;
	}
	
//	public void save(Tournament tournament) {
//				
//		tournamentRepository.save(tournament);
//	}

//	public void delete(Long id) {
//		tournamentRepository.deleteById(id);
//	}

	public void deleteAll() {
		tournamentRepository.deleteAll();
	}

}
