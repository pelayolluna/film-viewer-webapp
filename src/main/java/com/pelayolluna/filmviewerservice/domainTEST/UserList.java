package com.pelayolluna.filmviewerservice.domainTEST;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="users")
public class UserList {

	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}
	
}
