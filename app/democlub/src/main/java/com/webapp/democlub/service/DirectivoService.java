package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Directivo;
import com.webapp.democlub.repository.DirectivoRepository;

/*
* Creamos las funciones para nuestro controlador utilizando crud para la manipulacion de datos
* y hacer peticiones a nuestra base de datos
*C: Create
*R: Read
*U: Update
*D: Delete
*/

@Service
public class DirectivoService {

	@Autowired
	private DirectivoRepository directivoRepository;
	
	public List<Directivo> findAll(){
		List<Directivo> directivos = new ArrayList<>();
		Iterator<Directivo> directivoIt = directivoRepository.findAll().iterator();
		while(directivoIt.hasNext()) {
			directivos.add(directivoIt.next());
		}
		return directivos;
	}
	
	 
	public Directivo findById(Long id) {
		Directivo directivo = directivoRepository.findById(id).orElse(null);
		return directivo;
	}
	
	public void save(Directivo directivo) {
		directivoRepository.save(directivo);
	}
	
	public void delete(Long id) {
		directivoRepository.deleteById(id);
	}

}
