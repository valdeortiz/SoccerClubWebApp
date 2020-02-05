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

import com.webapp.democlub.domain.Person;
import com.webapp.democlub.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Person person = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		person = personService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (person == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Person>(person, HttpStatus.OK);
        
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> list() {
        return personService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Person person) {
    	Person newPerson = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newPerson = personService.save(person);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el person a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El person ha sido creado con exito");
        response.put("person", newPerson);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    	
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	personService.delete(id);
    }

}