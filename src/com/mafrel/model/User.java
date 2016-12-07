package com.mafrel.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
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
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
