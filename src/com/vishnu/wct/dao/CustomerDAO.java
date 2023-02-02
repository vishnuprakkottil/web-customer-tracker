package com.vishnu.wct.dao;

import java.util.List;

import com.vishnu.wct.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);

	public List<Customer> searchCustomer(String theSearchName);
}
