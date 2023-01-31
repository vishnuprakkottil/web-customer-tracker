package com.vishnu.wct.service;

import java.util.List;

import com.vishnu.wct.entity.Customer;

public interface CustomerService {


	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);
}
