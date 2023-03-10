package com.vishnu.wct.service;

import java.util.List;

import com.vishnu.wct.entity.Customer;

public interface CustomerService {


	public List<Customer> getCustomers(int sortField);

	public void addCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);

	public List<Customer> searchCustomer(String theSearchName);
}
