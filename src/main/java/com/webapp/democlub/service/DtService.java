package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.repository.DtRepository;
import com.webapp.democlub.repository.PlayerRepository;
import com.webapp.democlub.repository.TeamRepository;


@Service
public class DtService{

	@Autowired
	private DtRepository dtRepository;
	
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private PlayerRepository playerRepo;
	
	public Dt findById(Long id) {
		Dt dt = dtRepository.findById(id).orElse(null);
		return dt;
	}
	
	public List<Dt> findAll() {
		List<Dt> dts = new ArrayList<>();
		Iterator<Dt> iteratorDts = dtRepository.findAll().iterator();
		while (iteratorDts.hasNext()) {
			dts.add(iteratorDts.next());
		}
		return dts ;
	}
	
	public Dt save(Dt dt) throws InscripcionException{
		
		if (dt.teamObj() != null ) { // si newdt es distinto de null nomas es porque no dice que sea jugador del club			
			throw new RuntimeException("ejecute con put para inscribirse a un equipo");
		}else {
			if (dt.getSalary() == null) {
				throw new RuntimeException("Salary no puede ser null");
			}
			return dtRepository.save(dt);
		}
		
			
	}
	
	public Dt savePut(Dt dt) {
		Team team = teamRepo.findByName(dt.getTeam());
		Player newdt = playerRepo.findById(dt.getId()).orElse(null);
		if (team != null && newdt != null) { // si newdt es distinto de null nomas es porque no dice que sea jugador del club
			if (team.isPlayer(newdt) && newdt.getTrophies_number() > 1 ) {
				Dt dtof = new Dt(); 
				dtof = (Dt)newdt;
				System.err.println("legoegoeog");
				newdt.setTeam(team);
				//team.addEmployee(newdt);
				team.setDt(dtof);
				return dtRepository.save(dtof);
			}else {
				throw new RuntimeException("El dt no cumple con las condiciones. Debe ser jugador del equipo con mas de 1 trofeo ganado");
			}
			
		}else
			throw new RuntimeException("no existe el equipo o el id ");
		
	}

	public void delete(Long id) {
		dtRepository.deleteById(id);
	}
	public void deleteAll() {
		dtRepository.deleteAll();
	}
	

}
