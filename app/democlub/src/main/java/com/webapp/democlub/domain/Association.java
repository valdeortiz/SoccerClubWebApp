package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Association{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long id_employee;
	
	public void inscripcion() {
		//Buscar si el empleado existe y agregar en la lista en caso de que sea positivo, en caso de que no sea lanzar un error	
	}
		
}
