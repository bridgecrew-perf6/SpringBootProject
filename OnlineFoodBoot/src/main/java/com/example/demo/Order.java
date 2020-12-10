package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="orderitem")
public class Order {
	@Id
	private int ono;
	@Column(name="username")
	private String username;
	@ElementCollection
	private List<OrderItems> items=new ArrayList<OrderItems>();
	@Column(name="totalprice")
	private int totalprice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String username, List<OrderItems> items, int totalprice) {
		super();
		this.username = username;
		this.items = items;
		this.totalprice = totalprice;
	}
	
	
	
	public Order(String username, int totalprice) {
		super();
		this.username = username;
		this.totalprice = totalprice;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<OrderItems> getItems() {
		return items;
	}
	public void setItems(List<OrderItems> items) {
		this.items = items;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Order [ono=" + ono + ", username=" + username + ", items=" + items + ", totalprice=" + totalprice + "]";
	}
	
	
	

}
