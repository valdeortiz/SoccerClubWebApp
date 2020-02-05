package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Person;
import com.webapp.democlub.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
		
	public Person findById(Long id) {
		Person person = personRepository.findById(id).orElse(null);
		return person;
	}
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		Iterator<Person> iteratorPersons = personRepository.findAll().iterator();
		while (iteratorPersons.hasNext()) {
			persons.add(iteratorPersons.next());
		}
		return persons ;
	}
	
	public Person save(Person person) {
		if (person.getFirstName() != null && person.getLastName() != null) {
			return personRepository.save(person);
		}else
			throw new RuntimeException("EL nombre no debe ser null");
		
	}

	public void delete(Long id) {
		personRepository.deleteById(id);
	}

}
