package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Jugador;
import com.webapp.democlub.service.JugadorService;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jugador greetings(@PathVariable("id") Long id) {
        Jugador jugador = jugadorService.findById(id);
        return jugador;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Jugador> list() {
        return jugadorService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST) 
    public void add(@RequestBody Jugador jugador) {
    	jugadorService.save(jugador);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	jugadorService.delete(id);
    }

}