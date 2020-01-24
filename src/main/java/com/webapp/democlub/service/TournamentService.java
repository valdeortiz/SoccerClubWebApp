package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.repository.TournamentRepository;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;
		
	public Tournament findById(Long id) {
		Tournament tournament = tournamentRepository.findById(id).orElse(null);
		return tournament;
	}

	
	public List<Tournament> findAll() {
		List<Tournament> tournaments = new ArrayList<>();
		Iterator<Tournament> iteratorTournaments = tournamentRepository.findAll().iterator();
		while (iteratorTournaments.hasNext()) {
			tournaments.add(iteratorTournaments.next());
		}
		return tournaments;
	}
	
	public void save(Tournament tournament) {
		tournamentRepository.save(tournament);
	}

	public void delete(Long id) {
		tournamentRepository.deleteById(id);
	}

	public void deleteAll() {
		tournamentRepository.deleteAll();
	}

}
