package com.mafrel.model;

public class User {
	
	private String name;
	private int age;
	private String address;
	
	public User(){
		this.name="mafrel";
		this.age=23;
		this.address="ktm";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
