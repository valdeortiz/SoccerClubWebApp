package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String profession;
	private Integer salario;

	public void getSalario(Integer salario){
		this.salario = salario;
	}
	
	public Integer getSalario(){
		return salario;
	}

	public void setProfession(String profession){
		this.profession = profession;
	}
	
	public String getProfession(){
		return profession;
	}

	
	public void getId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}

	@Override
	public String toString() {
		return "salario del directivo: " + salario;
	}

	
}
