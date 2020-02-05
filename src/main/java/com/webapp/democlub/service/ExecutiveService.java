package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Executive;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.repository.ExecutiveRepository;
import com.webapp.democlub.repository.TeamRepository;

/*
* Creamos las funciones para nuestro controlador utilizando crud para la manipulacion de datos
* y hacer peticiones a nuestra base de datos
*C: Create
*R: Read
*U: Update
*D: Delete
*/

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Executive> findAll(){
		List<Executive> executives = new ArrayList<>();
		Iterator<Executive> executiveIt = executiveRepository.findAll().iterator();
		while(executiveIt.hasNext()) {
			executives.add(executiveIt.next());
		}
		return executives;
	}
	
	 
	public Executive findById(Long id) {
		Executive executive = executiveRepository.findById(id).orElse(null);
		return executive;
	}
	
	public void save(Executive executive) {
		Team team = teamRepository.findByName(executive.getTeam());
		if (team != null) {
			team.addEmployee(executive);
			executive.setTeamName(team.getName());
		}else {
			System.err.println("El equipo no existe o es nulo");
		}
		executiveRepository.save(executive);
	}
	public Executive savePut(Executive executive) {
		Team team = teamRepository.findByName(executive.getTeam());
		Executive exe = executiveRepository.findById(executive.getId()).orElse(null);
		if (team != null && exe != null) {
			team.addEmployee(executive);
			exe.setTeamName(team.getName());
		}else {
			System.err.println("El equipo no existe o es nulo");
			throw new RuntimeException("No existe el equipo o el id del directivo");
		}
		return executiveRepository.save(exe);
	}
	
	public void delete(Long id) {
		executiveRepository.deleteById(id);
	}

}
