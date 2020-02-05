package com.webapp.democlub.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Team;
import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.service.TournamentService;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Tournament tournament = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		tournament = tournamentService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (tournament == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Tournament>(tournament, HttpStatus.OK);
    }
    // retorna una lista con los equipos de la division(type)
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public List<Team> findByType(@PathVariable("type") String type) {
        List<Team> teams = tournamentService.findByType(type);
        return teams;
    }
    @RequestMapping(value = "/av/{name}", method = RequestMethod.GET)
    public List<String> average(@PathVariable("name") String name) {
        List<String> av = tournamentService.average(name);
        return av;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tournament> list() {
        return tournamentService.findAll();
    }
    
    @RequestMapping(value = "/ins/{team}/{tournament}", method = RequestMethod.PUT)
    public void inscripcion(@PathVariable("team") String name, @PathVariable("tournament") String tourn) {
    	tournamentService.insTourn(name, tourn);
  }

//    @RequestMapping(method = RequestMethod.POST)
//    public void add(@RequestBody Tournament tournament) {
//    	tournamentService.save(tournament);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable("id") Long id) {
//    	tournamentService.delete(id);
//    }

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteAll() {
		tournamentService.deleteAll();
	}

}