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
		Person person = new Person();
		return person;
	}

	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		return persons ;
	}

	
	public void save(Person person) {
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
