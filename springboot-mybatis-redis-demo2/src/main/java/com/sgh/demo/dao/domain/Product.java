package com.sgh.demo.dao.domain;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -8219751341403239152L;

	private long id;
	private String name;
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
