package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

	public List<Hotel> findAllByHotelname(String hotelname);
	public Hotel findByHno(int hno);

}
