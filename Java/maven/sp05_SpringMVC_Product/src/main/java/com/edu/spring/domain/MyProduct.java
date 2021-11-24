package com.edu.spring.domain;

public class MyProduct {
	
	//Encapsulation으로 필드 생성 - 컬럼명과 동일하게
	private int id;
	private String name;
	private String maker;
	private int price;
	
	//기본 생성자
	public MyProduct() {
	}

	//명시적 생성자
	public MyProduct(int id, String name, String maker, int price) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	
	//생성자 오버로딩
	public MyProduct(String name, String maker, int price) {
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	//setter / getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "MyProduct [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}

	
	
	
	
	
	
}
