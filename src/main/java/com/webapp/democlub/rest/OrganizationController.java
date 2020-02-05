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
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Organization organization = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		organization = organizationService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (organization == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Organization>(organization, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> greetings(@PathVariable("name") String name) {
    	Organization organization = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		organization = organizationService.findByName(name);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (organization == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Organization>(organization, HttpStatus.OK);
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