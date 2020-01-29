package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Team;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.service.TeamService;


@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team greetings(@PathVariable("id") Long id) {
        Team team = teamService.findById(id);
        return team;
    }
    @RequestMapping(value = "/av/{name}", method = RequestMethod.GET)
    public List<String> average(@PathVariable("name") String name ) {
    	List<String> av = teamService.average(name);
        return av;
    }
    
    @RequestMapping(value = "/div/{div}", method = RequestMethod.GET)
    public List<Team> findByDvi(@PathVariable("div") String div) {
    	List<Team> team = teamService.findByDivision(div);
        return team;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Team> list() {
        return teamService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Team team) throws InscripcionException {
    	//try catch de inscripcion del dt
//    	try {
//			teamService.save(team);
//		} catch (InscripcionException e) {
//			String email = e.getContacto();
//			System.out.println("Ocurrió un error al inscribir las empresas: " + e.getMessage());
//		}
    	try {
    		teamService.save(team);
		} catch (InscripcionException e) {
			String email = e.getContacto();
			System.err.println(email);
			System.out.println("Ocurrió un error al inscribir los TEAM: " + e.getMessage());
		}
    	
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	teamService.delete(id);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {
    	teamService.deleteAll();
    	}

}