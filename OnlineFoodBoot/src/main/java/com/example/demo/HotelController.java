package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HotelController {
	@Autowired
	HotelService hotelService;

	@RequestMapping("/register-hotel")
	public String openAddHotel() {
		return "addhotel";
	}

	@RequestMapping("/register-h")
	public String registerHote(@ModelAttribute Hotel hotel, BindingResult binResult) {
		hotelService.registerHotel(hotel);
		return "addhotel";
	}

	@RequestMapping("/add-items-to-Hotels")
	public String showHotelsToAddItems(HttpServletRequest request) {
		List<Hotel> hotels = hotelService.getAllHotels();
		request.setAttribute("hotels", hotels);
		return "showallhotelstoadditems";
	}

	@RequestMapping("/add-items-h")
	public String openaddItemsToHotel(@RequestParam int hno, HttpServletRequest request) {
		request.setAttribute("hno", hno);
		return "additems";

	}

	@RequestMapping("/additeme-hotel")
	public String addItems(@RequestParam int hno, @RequestParam String itemname, @RequestParam int price,
			HttpServletRequest request) {
		Items i = new Items(hno, itemname, price);
		hotelService.addItems(i);
		request.setAttribute("hno", hno);
		return "additems";
	}

	@RequestMapping("/get-All-Hotels")
	public String getAllHotels(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_All_HOTELS");
		List<Hotel> hotels = hotelService.getAllHotels();
		request.setAttribute("hotels", hotels);
		return "easyfood";
	}

	@RequestMapping("/getAllItemsByHno")
	public String getAllItems(@RequestParam int hno, HttpServletRequest request) {
		List<Items> l = hotelService.getAllItemaByHno(hno);
		request.setAttribute("items", l);
		return "getitems";
	}

	@RequestMapping("/addToCart")
	public String addItemsToCart(HttpServletRequest request, @RequestParam int hno, @RequestParam int ino,
			@RequestParam String itemname, @RequestParam int price) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		Cart cart = new Cart(username, hno, ino, itemname, price);
		hotelService.addToCart(cart);
		List<Items> l = hotelService.getAllItemaByHno(hno);
		request.setAttribute("items", l);
		return "getitems";
	}

	@RequestMapping("/search-hotel")
	public String openHotel(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_SEARCH");
		return "easyfood";
	}

	@RequestMapping("/search")
	public String searchHotel(@RequestParam String hotelname, HttpServletRequest request) {
		List<Hotel> h = hotelService.findAllByHotelname(hotelname);
		List<Items> i = hotelService.findAllByItems(hotelname);
		if (h.size() != 0) {
			request.setAttribute("hotels", hotelService.findAllByHotelname(hotelname));
			return "searchhotel";
		} else if (i.size() != 0) {
			request.setAttribute("items", hotelService.findAllByItems(hotelname));
			return "searchitem";
		} else {
			return "searcherror";
		}
	}

	@RequestMapping("/getHotelByHotelNo")
	public String getHotelsByHno(@RequestParam int hno, HttpServletRequest request) {
		Hotel h = hotelService.findByHno(hno);
		request.setAttribute("hotel", h);
		return "searchhotelbyhotelno";

	}

	@RequestMapping("/show-cart")
	public String showCartItems(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		if (cart.size() == 0) {
			return "carterror";
		} else {
			request.setAttribute("cart", cart);
			int total = 0;
			for (int i = 0; i < cart.size(); i++) {

				total = total + cart.get(i).getPrice();
			}
			int sum = total;
			request.setAttribute("cart", cart);
			request.setAttribute("totalprice", total);
			return "cart";
		}
	}

	@RequestMapping("/removefromcart")
	public String removefromcaret(@RequestParam int no, HttpServletRequest request) {
		hotelService.deleteByCno(no);
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		if (cart.size() == 0) {
			return "carterror";
		} else {
			request.setAttribute("cart", cart);
			int total = 0;
			for (int i = 0; i < cart.size(); i++) {

				total = total + cart.get(i).getPrice();
			}
			int sum = total;
			request.setAttribute("cart", cart);
			request.setAttribute("totalprice", total);
			return "cart";
		}

	}

	@RequestMapping("/get-saved-addresses")
	public String getAllAddress(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		if (hotelService.getAllAddresses(username).size() == 0) {
			return "addresserror";
		} else {

			request.setAttribute("addresses", hotelService.getAllAddresses(username));
			return "getsavedaddress";
		}
	}

	@RequestMapping("/add-address")
	public String openAddAddress() {
		return "addaddress";
	}

	@RequestMapping("/add-address-into-database")
	public String addAddress(@ModelAttribute Address address, BindingResult bindingResult, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		Address a = new Address(username, address.getHouseno(), address.getFlat(), address.getLandmark(),
				address.getArea(), address.getCity(), address.getCity(), address.getPincode());
		hotelService.addAddress(a);
		request.setAttribute("addresses", hotelService.getAllAddresses(username));
		return "getsavedaddress";

	}

	@RequestMapping("/selectaddress")
	public String openAllPayments(@RequestParam int ano, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		int total = 0;
		for (int i = 0; i < cart.size(); i++) {

			total = total + cart.get(i).getPrice();
		}
		request.setAttribute("cart", cart);
		request.setAttribute("totalprice", total);
		Address a = hotelService.getAdressDetailsBySAno(ano);
		request.setAttribute("hno", a.getHouseno());
		request.setAttribute("flat", a.getFlat());
		request.setAttribute("landmark", a.getLandmark());
		request.setAttribute("area", a.getArea());
		request.setAttribute("city", a.getCity());
		request.setAttribute("pincode", a.getPincode());

		return "allorderdetails";

	}

	@RequestMapping("/apply-offer")
	public String openApplyOffer(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		int total = 0;
		for (int i = 0; i < cart.size(); i++) {

			total = total + cart.get(i).getPrice();
		}
		request.setAttribute("cart", cart);
		request.setAttribute("totalprice", total);
		return "applyoffer";
	}

	@RequestMapping("/applycoupon")
	public String applyOffer(@RequestParam String coupon, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		int total = 0;
		for (int i = 0; i < cart.size(); i++) {

			total = total + cart.get(i).getPrice();
		}
		int count = hotelService.findAllCartByUsername(username).size();
		int sum = total;
		if (coupon.equals("new50") && count <= 5) {
			sum = (int) (sum * 0.5);
		} else {
			sum = (int) (sum);
		}
		request.setAttribute("sum", sum);
		Order order = new Order(username, sum);
		hotelService.saveOrder(order);
		return "totalpricepage";

	}

	@RequestMapping("/payments")
	public String openPaymentsPage() {
		return "paymentspage";
	}

	@RequestMapping("/orderplace")
	@ResponseBody
	public String status() {
		return "Order Placed Successfully";
	}

	@RequestMapping("/account")
	public String openAccount(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ACCOUNT");
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		request.setAttribute("username", username);
		return "easyfood";
	}

	@RequestMapping("/accountdetails")
	public String accountDetails(HttpServletRequest request) {

		return "easyfood";

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "logincustomer";
	}

	@RequestMapping("/help")
	public String openHelpPage() {
		return "helppage";
	}

	@RequestMapping("/save-into-order")
	public String saveToOrder(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		List<Cart> cart = hotelService.showCartItems(username);
		int total = 0;
		for (int i = 0; i < cart.size(); i++) {

			total = total + cart.get(i).getPrice();
		}
		request.setAttribute("cart", cart);
		request.setAttribute("totalprice", total);
		Order order = new Order(username, total);
		hotelService.saveOrder(order);
		return "paymentspage";

	}

}
