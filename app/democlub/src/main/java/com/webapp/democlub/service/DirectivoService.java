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
	
	
	public Directivo findById(Long id) {
		Directivo directivo = new Directivo();
		return directivo;
	}
	
	public void save(Directivo directivo) {
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
