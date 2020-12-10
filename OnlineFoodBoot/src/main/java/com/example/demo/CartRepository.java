package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	public List<Cart> findAllByUsername(String username);

}
