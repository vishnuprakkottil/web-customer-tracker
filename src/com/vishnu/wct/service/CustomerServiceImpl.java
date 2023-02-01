package com.vishnu.wct.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.wct.dao.CustomerDAO;
import com.vishnu.wct.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		
		try {
			return customerDAO.getCustomerById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
