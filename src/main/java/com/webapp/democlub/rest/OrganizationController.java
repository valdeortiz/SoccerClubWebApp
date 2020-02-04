package com.webapp.democlub.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Organization;
import com.webapp.democlub.service.OrganizationService;


@RestController
@RequestMapping("/ong")
public class OrganizationController {
    // Creamos un objero de tipo Asso.Service donde tenemos la logica de cada metodo
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Organization> findAll(){
		return organizationService.findAll();
		
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Organization greetings(@PathVariable("id") Long id) {
        Organization organization = organizationService.findById(id);
        return organization;
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Organization greetings(@PathVariable("name") String name) {
        Organization organization = organizationService.findByName(name);
        return organization;
    }
    
//    @RequestMapping(method = RequestMethod.POST)
//    public void add(@RequestBody Organization organization) {
//    	organizationService.save(organization);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	organizationService.delete(id);
    }

}