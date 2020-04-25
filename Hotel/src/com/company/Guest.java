package com.company;
import java.io.Serializable;

public class Guest implements Serializable{
	public static final long serialVersionUID = -4013719443428362152L;
	private String name;
	private String address;
	private String country;
	private String gender;
	private String nationality;
	private long phoneNumber;
	private String passportNumber;
	private CreditCard creditCard;
	private double cash;


	public Guest(String name, String address, String country, String gender, String nationality, long phoneNumber,  String passportNumber,  CreditCard creditCard, double cash ) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.gender = gender;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.passportNumber = passportNumber;
        this.creditCard=creditCard;
        this.cash=cash;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	

//
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country=country;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality=nationality;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber=phoneNumber;
	}

	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber=passportNumber;
	}



	public CreditCard getCreditCard(){  return creditCard;}

	public void setCreditCard(CreditCard creditCard){  this.creditCard=creditCard;}

	public double getCash()  {return cash;}

	public void setCash(double cash)   {this.cash=cash;}




		



}
