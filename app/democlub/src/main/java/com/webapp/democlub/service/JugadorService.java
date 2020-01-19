package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Jugador;
import com.webapp.democlub.repository.JugadorRepository;

@Service
public class JugadorService {

	@Autowired
	private JugadorRepository jugadorRepository;
		
	public Jugador findById(Long id) {
		Jugador jugador = jugadorRepository.findById(id).orElse(null);
		return jugador;
	}

	
	public List<Jugador> findAll() {
		List<Jugador> jugadors = new ArrayList<>();
		Iterator<Jugador> iteratorJugadors = jugadorRepository.findAll().iterator();
		while (iteratorJugadors.hasNext()) {
			jugadors.add(iteratorJugadors.next());
		}
		return jugadors ;
	}
	
	public void save(Jugador jugador) {
		jugadorRepository.save(jugador);
	}

	public void delete(Long id) {
		jugadorRepository.deleteById(id);
	}
	public void deleteAll() {
		jugadorRepository.deleteAll();
	}

}
