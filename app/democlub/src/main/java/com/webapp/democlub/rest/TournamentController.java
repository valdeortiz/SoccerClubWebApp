package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.service.TournamentService;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tournament greetings(@PathVariable("id") Long id) {
        Tournament tournament = tournamentService.findById(id);
        return tournament;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tournament> list() {
        return tournamentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Tournament tournament) {
    	tournamentService.save(tournament);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	tournamentService.delete(id);
    }

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteAll() {
		tournamentService.deleteAll();
	}

}