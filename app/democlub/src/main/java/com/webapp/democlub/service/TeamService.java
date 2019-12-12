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
		Team team = new Team(id, null, null);
		return team;
	}

	
	public List<Team> findAll() {
		List<Team> teams = new ArrayList<>();
		return teams;
	}

	
	public void save(Team team) {
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
