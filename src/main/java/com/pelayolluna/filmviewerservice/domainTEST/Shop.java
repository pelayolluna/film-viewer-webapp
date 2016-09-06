package com.pelayolluna.filmviewerservice.domainTEST;

public class Shop {

	long id;
	String name;
	String staffName[];

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getStaffName() {
		return staffName;
	}

	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}

	public Shop() {
	}

}
