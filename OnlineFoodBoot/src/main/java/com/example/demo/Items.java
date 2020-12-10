
package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Items {
	@Id
	private int ino;
	private int hno;
	private String itemname;
	private int price;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Items(int hno, String itemname, int price) {
		super();
		this.hno = hno;
		this.itemname = itemname;
		this.price = price;
	}

	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
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
		return "Item [ino=" + ino + ", hno=" + hno + ", itemname=" + itemname + ", price=" + price + "]";
	}
	

}
