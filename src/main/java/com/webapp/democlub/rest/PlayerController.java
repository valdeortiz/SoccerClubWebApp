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

import com.webapp.democlub.domain.Player;
import com.webapp.democlub.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Player player = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		player = playerService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (player == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }
    @RequestMapping(value = "/prom/{id}", method = RequestMethod.GET)
    public Double average(@PathVariable("id") Long id) {
        Double average = playerService.promedio(id);
        return average;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Player> list() {
        return playerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST) 
    public ResponseEntity<?> add(@RequestBody Player player) {
    	Player newPlayer = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newPlayer = playerService.save(player);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el player a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El player ha sido creado con exito");
        response.put("player", newPlayer);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	playerService.delete(id);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {
    	playerService.deleteAll();
    }
    

}