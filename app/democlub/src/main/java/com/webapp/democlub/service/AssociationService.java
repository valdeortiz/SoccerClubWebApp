package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.repository.AssociationRepository;


@Service
public class AssociationService {

	@Autowired
	private AssociationRepository associationRepository;
	
	/*Buscamos un association segun su id  */ 
	public Association findById(Long id) {
		Association association = new Association();
		return association;
	}
	/*Funcion para la inscripcion segun el tipo de Empleado o equipo*/
	public void save(Association association) {
	}
	/*Borrar algun equipo o empleado */
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
