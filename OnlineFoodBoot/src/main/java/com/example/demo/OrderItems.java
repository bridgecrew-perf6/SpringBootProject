package com.example.demo;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItems {
	

	private int hotelno;
	private int itemno;
	private String itemname;

	
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
	@Override
	public String toString() {
		return "OrderItems [hotelno=" + hotelno + ", itemno=" + itemno + ", itemname=" + itemname + "]";
	}
	


}
