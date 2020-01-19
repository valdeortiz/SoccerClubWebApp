package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Executive;
import com.webapp.democlub.repository.ExecutiveRepository;

/*
* Creamos las funciones para nuestro controlador utilizando crud para la manipulacion de datos
* y hacer peticiones a nuestra base de datos
*C: Create
*R: Read
*U: Update
*D: Delete
*/

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	public List<Executive> findAll(){
		List<Executive> executives = new ArrayList<>();
		Iterator<Executive> executiveIt = executiveRepository.findAll().iterator();
		while(executiveIt.hasNext()) {
			executives.add(executiveIt.next());
		}
		return executives;
	}
	
	 
	public Executive findById(Long id) {
		Executive executive = executiveRepository.findById(id).orElse(null);
		return executive;
	}
	
	public void save(Executive executive) {
		executiveRepository.save(executive);
	}
	
	public void delete(Long id) {
		executiveRepository.deleteById(id);
	}

}
