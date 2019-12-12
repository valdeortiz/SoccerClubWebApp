package com.webapp.democlub.domain;

public class Torneos {
/**
	 * @param name
	 * @param type
	 */
	public Torneos(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
private String name;
private String type;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
 