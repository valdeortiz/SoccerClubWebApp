package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Player greetings(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        return player;
    }
    @RequestMapping(value = "/prom/{id}", method = RequestMethod.GET)
    public Float average(@PathVariable("id") Long id) {
        Float average = playerService.promedio(id);
        return average;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Player> list() {
        return playerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST) 
    public void add(@RequestBody Player player) {
    	playerService.save(player);
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