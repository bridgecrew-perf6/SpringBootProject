package com.example.demo;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	@ResponseBody
	public String check(HttpServletRequest request) {
		return "working";
	}

	@RequestMapping("/home")
	public String openHomePage() {
		return "home";
	}
	@RequestMapping("/login-customer")
	public String openLoginCustomer() {
		return "logincustomer";
	}

	@RequestMapping("/register-customer")
	public String openRegisterCustomer() {
		return "registercustomer";
	}

	@RequestMapping("/register")
	public String registerCustomer(@ModelAttribute Customer customer, BindingResult bindingResult) {
		if (customerService.findByUsername(customer.getUsername()) == null) {
			customerService.registerCustomer(customer);
			return "logincustomer";
		} else {
return "customerregistererror";
		}
	}
	@RequestMapping("/admin-page")
	public String openadmin() {
		return "admin";
	}

	@RequestMapping("/admin-verify")
	public String adminLogin(@RequestParam String admin, @RequestParam String password) {
		if (admin.equals(admin) && password.equals(admin)) {
			return "addhotel";
		} else {
			return "admin";
		}

	}


	
	@RequestMapping("/login")
	public String loginCustomer(@RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		if (customerService.findByUsernameAndPassword(username, password) != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
			return "easyfood";
		} else {
			return "logincustomer";
		}

	}

	
}
