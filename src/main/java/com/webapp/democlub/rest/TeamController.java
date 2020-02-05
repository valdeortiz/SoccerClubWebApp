package com.webapp.democlub.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Team team = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		team = teamService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (team == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Team>(team, HttpStatus.OK);
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
    public ResponseEntity<?> add(@RequestBody Team team) throws InscripcionException {
    	Team newTeam = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newTeam = teamService.save(team);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el team a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El team ha sido creado con exito");
        response.put("team", newTeam);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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