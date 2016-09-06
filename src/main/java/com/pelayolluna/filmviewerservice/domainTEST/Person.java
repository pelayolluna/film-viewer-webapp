package com.pelayolluna.filmviewerservice.domainTEST;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="person")
public class Person {
	
	private long id;
	private String firstName;
	private String lastName;
	private double money;
	
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", first=" + firstName + ", lastName="
				+ lastName + ", money=" + money + "]";
	}

        @Override
        public int hashCode() {
            if(id!=0) {
                return (int) (id*7);
            }
            return 31*13*7;
        }

        @Override
        public boolean equals(Object obj) {
            if(hashCode()==obj.hashCode()) {
                return true;
            }
            if(obj==null){
                return false;
            }
            return false;
        }
        
        public String toJson() {
            return "{\"id\":"+ id + ",\"firstName\":"+ firstName 
                    + ",\"lastName\":" + lastName + ",\"money\":" + money + "}";
        }
	
	
}
