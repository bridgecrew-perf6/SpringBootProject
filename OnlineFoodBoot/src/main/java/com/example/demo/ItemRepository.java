package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Items, Integer> {
	public List<Items> findAllByHno(int hno);

	public List<Items> findAllByItemname(String hotelname);

}
