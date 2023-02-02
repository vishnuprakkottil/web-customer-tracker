package com.vishnu.wct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vishnu.wct.entity.Customer;
import com.vishnu.wct.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> customers = customerService.getCustomers();

		model.addAttribute("customers", customers);
		return "list-customers";

	}

	@GetMapping("/addNewCustomer")
	public String addNewCustomer(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "add-customer";

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.addCustomer(customer);
		return "redirect:/customer/list";

	}

	@GetMapping("/viewCustomer")
	public String getCustomer(@RequestParam("customerId") int id,
					Model model) {

		Customer customerById = customerService.getCustomerById(id);
		model.addAttribute("customer", customerById);

		return "add-customer";

	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id,
					Model model) {

		customerService.deleteCustomerById(id);

		return "redirect:/customer/list";

	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam(value ="theSearchName", required=false) String theSearchName,
					Model model) {
		
		if (theSearchName.trim().length() == 0) {
			return "redirect:/customer/list";
		}		
		
		List<Customer> customers = customerService.searchCustomer(theSearchName);

		model.addAttribute("customers", customers);
		return "list-customers";	

	}
}
