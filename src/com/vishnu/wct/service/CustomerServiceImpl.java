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
	public List<Customer> getCustomers(int sortField) {

		return customerDAO.getCustomers(sortField);
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

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		
		try {
			customerDAO.deleteCustomerById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String theSearchName) {
		
		try {
			return customerDAO.searchCustomer(theSearchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
