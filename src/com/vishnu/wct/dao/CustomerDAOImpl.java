package com.vishnu.wct.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vishnu.wct.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// injecting hibernate session factory
	@Autowired
	private SessionFactory sessionFactory; // same as bean id in xml file

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = new ArrayList<>();
		try {
			Query<Customer> query =
					session.createQuery("from Customer", Customer.class);
			customers = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

}
