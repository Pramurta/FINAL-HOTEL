package com.company;
import java.io.Serializable;

public class MenuItem implements Serializable{
	private int id;
	private String name;
	private String description;
	private double price;

	public MenuItem(int id, String name, String description, double price) {
		this.name=name;
		this.description=description;
		this.price=price;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id){ this.id=id;}
}
