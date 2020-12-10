package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	public List<Order> findAllByUsername(String username);

}
