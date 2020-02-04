package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.repository.PlayerRepository;
import com.webapp.democlub.repository.TeamRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepo;
		
	public Player findById(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		return player;
	}
	public Double promedio(Long id) {
		Player player = findById(id);
		return player != null ? player.getAverage_salary() : 0.0 ;
		
	}

	
	public List<Player> findAll() {
		List<Player> players = new ArrayList<>();
		Iterator<Player> iteratorPlayers = playerRepository.findAll().iterator();
		while (iteratorPlayers.hasNext()) {
			players.add(iteratorPlayers.next());
		}
		return players ;
	}
	
	public void save(Player player) {
		Team team = teamRepo.findByName(player.getTeam());
		if (team != null) {
			player.setTeam(team);
			team.addPlayer(player);
			playerRepository.save(player);
		}else {
			//lanzar excepcions
			// team = sin equipo
			System.err.println("No se pudo guardar player: null team");
		}
		
	}

	public void delete(Long id) {
		playerRepository.deleteById(id);
	}
	
	public void deleteAll() {
		playerRepository.deleteAll();
	}

}
