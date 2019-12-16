package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.service.AssociationService;


@RestController
@RequestMapping("/association")
public class AssociationController {
    // Creamos un objero de tipo Asso.Service donde tenemos la implemetacion de cada metodo
	@Autowired
	private AssociationService associationService;
    // buscamos un objeto segun su id.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Association greetings(@PathVariable("id") Long id) {
        Association association = associationService.findById(id);
        return association;
    }
    // metodo para la inscripcion de un objeto que puede ser empleado o directivo.
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Association association) {
    	associationService.save(association);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	associationService.delete(id);
    }

}