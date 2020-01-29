package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.repository.DtRepository;
import com.webapp.democlub.repository.TeamRepository;


@Service
public class DtService {

	@Autowired
	private DtRepository dtRepository;
	
	@Autowired
	private TeamRepository teamRepo;
	
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
	
	public void save(Dt dt) throws InscripcionException{
		Team team = teamRepo.findByName(dt.getTeam());
		if (team != null) {
			dt.setTeam(team);
			team.setDt(dt);
			dtRepository.save(dt);
		}else {
			
			//lanzar excepcions
			// team = sin equipo
			System.err.println("No se pudo guardar player: null team");
		}
		
		
	}

	public void delete(Long id) {
		dtRepository.deleteById(id);
	}
	public void deleteAll() {
		dtRepository.deleteAll();
	}
	

}
