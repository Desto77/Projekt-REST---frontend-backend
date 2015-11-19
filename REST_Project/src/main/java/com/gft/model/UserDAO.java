package com.gft.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserDAO {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;
	private int age;

	@OneToOne(cascade = {CascadeType.ALL})
	private UserDetailsDAO details;

	public UserDAO() {
	}

	public UserDAO(String firstName, String lastName, int age, UserDetailsDAO details) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserDetailsDAO getDetails() {
		return details;
	}

	public void setDetails(UserDetailsDAO details) {
		this.details = details;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
//				+ " | Details: {address=" + details.getAddress() + ", city=" + details.getCity() + ", number="
//				+ details.getNumber() + "}]";
//	}

}