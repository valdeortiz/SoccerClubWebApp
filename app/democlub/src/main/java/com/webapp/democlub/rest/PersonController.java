package com.webapp.democlub.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Person greetings(@PathVariable("id") Long id) {
        Person person = personService.findById(id);
        return person;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> list() {
        return personService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Person person) {
    	personService.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	personService.delete(id);
    }

}