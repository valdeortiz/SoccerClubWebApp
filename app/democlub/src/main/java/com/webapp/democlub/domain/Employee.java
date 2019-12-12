package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param profession
	 * @param salario
	 */
	public Employee(long id, String profession, Integer salario) {
		super();
		this.id = id;
		this.profession = profession;
		this.salario = salario;
	}

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
