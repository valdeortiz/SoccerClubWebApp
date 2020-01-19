package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Team;
import com.webapp.democlub.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
		
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
		teamRepository.save(team);
	}

	public void delete(Long id) {
		teamRepository.deleteById(id);
	}

	public void deleteAll() {
		teamRepository.deleteAll();
	}

}
