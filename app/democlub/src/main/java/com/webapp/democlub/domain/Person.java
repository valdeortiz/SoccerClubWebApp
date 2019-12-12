package com.webapp.democlub.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Person {

	/**
	 * @param firstName
	 * @param id
	 * @param lastName
	 */
	public Person(String firstName, long id, String lastName) {
		super();
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
	}

	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName;
	}
	
}
