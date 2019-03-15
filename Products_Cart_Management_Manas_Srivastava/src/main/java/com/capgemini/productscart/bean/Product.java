package com.capgemini.productscart.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Pattern(regexp="^[a-z]{1}[0-9]+$",message="enter valid id")
	private String id;
	
	@NotNull
	@Pattern(regexp="^[A-Z][a-z]+$",message="enter valid product name")
	private String name;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z0-9 /fs]+$",message="enter valid model")
	private String model;
	
	private int price;
	
	public Product(@Pattern(regexp = "^[a-z]{1}[0-9]+$", message = "enter valid id") String id,
			@NotNull @Pattern(regexp = "^[A-Z][a-z]+$", message = "enter valid product name") String name,
			@NotNull @Pattern(regexp = "^[A-Za-z/fs]+$", message = "enter valid model") String model, int price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}
	
	public Product() {
		super();
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
