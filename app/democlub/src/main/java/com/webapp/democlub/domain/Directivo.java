package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
* Modelamos cada uno de nuestros objetos a ser utilizado.
*
*/
@Entity
public class Directivo extends Person{
	/**
	 * @param id
	 * @param salario
	 */
	public Directivo(long id, Integer salario) {
		super();
		this.id = id;
		this.salario = salario;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Integer salario; // mover salario a person

	public void getSalario(Integer salario){
		this.salario = salario;
	}
	
	public Integer getSalario(){
		return salario;
	}
	
	public void getId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	// crear el constructor
	@Override
	public String toString() {
		return "salario del directivo: " + salario;
	}

	
}
