package com.vishnu.wct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vishnu.wct.entity.Customer;
import com.vishnu.wct.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject the customer service
	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> customers = customerService.getCustomers();

		model.addAttribute("customers",customers);
		return "list-customers";

	}
}
