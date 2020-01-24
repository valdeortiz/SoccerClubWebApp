package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Player;
import com.webapp.democlub.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
		
	public Player findById(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		return player;
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
		playerRepository.save(player);
	}

	public void delete(Long id) {
		playerRepository.deleteById(id);
	}
	public void deleteAll() {
		playerRepository.deleteAll();
	}

}
