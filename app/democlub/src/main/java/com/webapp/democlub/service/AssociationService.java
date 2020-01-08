package com.webapp.democlub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.repository.AssociationRepository;


@Service
public class AssociationService {

	@Autowired /*Esto significa que vamos a inyectar*/
	private AssociationRepository associationRepository;
	
	/*Buscamos un association segun su id  */ 
	public Association findById(Long id) {
		Association association = associationRepository.findById(id).orElse(null);
		return association;
	}
	/*Funcion para la inscripcion segun el tipo de Empleado o equipo*/
	public void save(Association association) {
		associationRepository.save(association);
	}
	/*Borrar algun equipo o empleado segun su id generado dinamicamente en el entity*/
	public void delete(Long id) {
		associationRepository.deleteById(id);
	}

}
