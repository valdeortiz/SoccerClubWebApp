package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dt extends Jugador{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Integer salario;

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

	@Override
	public String toString() {
		return "salario del Dt: " + salario;
	}

	
}
