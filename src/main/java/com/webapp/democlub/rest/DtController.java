package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.service.DtService;

@RestController
@RequestMapping("/dt")
public class DtController {

	@Autowired
	private DtService dtService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dt greetings(@PathVariable("id") Long id) {
        Dt dt = dtService.findById(id);
        return dt;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Dt> list() {
        return dtService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Dt dt) throws InscripcionException {
    	dtService.save(dt);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	dtService.delete(id);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {
    	dtService.deleteAll();
    }

}