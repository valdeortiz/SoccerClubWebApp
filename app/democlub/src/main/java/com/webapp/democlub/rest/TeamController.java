package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Team;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Team> list() {
        return teamService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Team team) {
    	teamService.save(team);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	teamService.delete(id);
    }

}