package com.ab.criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Citizenship {

	@Id
	@Column(name="AADHAR")
	private long aadharNumber;
	@Column(name="PASSPORT")
	private long passportNumber;
	
	private String name;
	private String surname;
	
	public Citizenship() {
		super();
	
	}
	public Citizenship(String name, String surname, long aadharNumber, long passportNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.aadharNumber = aadharNumber;
		this.passportNumber = passportNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public long getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(long passportNumber) {
		this.passportNumber = passportNumber;
	}
	@Override
	public String toString() {
		return "\n Citizen [name=" + name + ", surname=" + surname + ", aadharNumber=" + aadharNumber + ", passportNumber="
				+ passportNumber + "]";
	}
	
	
}//citizen
