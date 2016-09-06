package com.pelayolluna.filmviewerservice.domainTEST;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="user")
public class User {

	private Long id;
	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
