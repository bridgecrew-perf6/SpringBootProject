package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	private int no;
	private String username;
	private int hotelno;
	private int itemno;
	private String itemname;
	private int price;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String username, int hotelno, int itemno, String itemname, int price) {
		super();
		this.username = username;
		this.hotelno = hotelno;
		this.itemno = itemno;
		this.itemname = itemname;
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHotelno() {
		return hotelno;
	}
	public void setHotelno(int hotelno) {
		this.hotelno = hotelno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [no=" + no + ", username=" + username + ", hotelno=" + hotelno + ", itemno=" + itemno
				+ ", itemname=" + itemname + ", price=" + price + "]";
	}
	

}
