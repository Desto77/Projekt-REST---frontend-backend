package com.gft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetailsDAO {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String address;
	private String city;
	private int number;
	
	public UserDetailsDAO() {
	}
	
	public UserDetailsDAO(String address, String city, int number) {
		this.address = address;
		this.city = city;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	

}
