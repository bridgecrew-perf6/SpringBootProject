package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

	public List<Address> findAllByUser(String username);

	public Address findByAno(int ano);

}
