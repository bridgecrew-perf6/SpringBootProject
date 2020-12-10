package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class HotelService {
	public final HotelRepository hotelRepository;
	public final ItemRepository itemRepository;
	public final CartRepository cartRepository;
	public final AddressRepository addressRepository;
	public final OrderRepository orderRepository;

	public HotelService(HotelRepository hotelRepository, ItemRepository itemRepository, CartRepository cartRepository,
			AddressRepository addressRepository, OrderRepository orderRepository) {
		this.hotelRepository = hotelRepository;
		this.itemRepository = itemRepository;
		this.cartRepository = cartRepository;
		this.addressRepository = addressRepository;
		this.orderRepository = orderRepository;
	}

	public void registerHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		for (Hotel hotel : hotelRepository.findAll()) {
			hotels.add(hotel);
		}
		return hotels;
	}

	public void addItems(Items i) {
		itemRepository.save(i);
	}

	public List<Items> getAllItemaByHno(int hno) {
		List<Items> items = new ArrayList<Items>();
		for (Items item : itemRepository.findAllByHno(hno)) {
			items.add(item);
		}
		return items;
	}

	public void addToCart(Cart cart) {
		cartRepository.save(cart);
	}

	public List<Cart> showCartItems(String username) {
		List<Cart> carts = new ArrayList<Cart>();
		for (Cart cart : cartRepository.findAllByUsername(username)) {
			carts.add(cart);
		}
		return carts;
	}

	public List<Hotel> findAllByHotelname(String hotelname) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		for (Hotel hotel : hotelRepository.findAllByHotelname(hotelname)) {
			hotels.add(hotel);
		}
		return hotels;
	}

	public void addAddress(Address address) {
		addressRepository.save(address);

	}

	public List<Address> getAllAddresses(String username) {
		List<Address> addresses = new ArrayList<Address>();
		for (Address address : addressRepository.findAllByUser(username)) {
			addresses.add(address);

		}
		return addresses;
	}

	public void saveOrder(Order order) {
		orderRepository.save(order);

	}

	public void deleteByCno(int cno) {
		cartRepository.deleteById(cno);
	}

	public Address getAdressDetailsBySAno(int ano) {
		return addressRepository.findByAno(ano);

	}

	public List<Items> findAllByItems(String hotelname) {
		List<Items> items=new ArrayList<Items>();
		for (Items item : itemRepository.findAllByItemname(hotelname)) {
			items.add(item);
		}
		return items;
	}

	public Hotel findByHno(int hno) {
	return	hotelRepository.findByHno(hno);
		
	}

	public List<Order> findAllCartByUsername(String username) {
	return	orderRepository.findAllByUsername(username);
	}

}
