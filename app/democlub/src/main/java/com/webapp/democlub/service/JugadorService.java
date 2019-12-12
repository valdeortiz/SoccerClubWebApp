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
		Jugador jugador = new Jugador();
		return jugador;
	}

	
	public List<Jugador> findAll() {
		List<Jugador> jugadors = new ArrayList<>();
		return jugadors ;
	}

	
	public void save(Jugador jugador) {
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
