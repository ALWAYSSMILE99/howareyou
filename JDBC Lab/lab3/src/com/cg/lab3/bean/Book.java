package com.cg.lab3.bean;

import java.math.BigInteger;

public class Book {
	private BigInteger isbn;
	private String title;
	private double price;
	public BigInteger getIsbn() {
		return isbn;
	}
	public void setIsbn(BigInteger isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
