package com.vishnu.wct.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vishnu.wct.entity.Customer;
import com.vishnu.wct.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// injecting hibernate session factory
	@Autowired
	private SessionFactory sessionFactory; // same as bean id in xml file

	@Override
	public List<Customer> getCustomers(int sortField) {

		Session session = sessionFactory.getCurrentSession();
		String theFieldName = null;
		
		switch (sortField) {
			case SortUtils.ID: 
				theFieldName = "id";
				break;
			case SortUtils.FIRST_NAME: 
				theFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				theFieldName = "firstName";
		}
		List<Customer> customers = new ArrayList<>();
		try {
			String queryString = "from Customer order by " + theFieldName;
			Query<Customer> query =
					session.createQuery(queryString, Customer.class);
			customers = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomerById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, id));
		
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            query =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName or id like :theName order by firstName asc", Customer.class);
            query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
        	session.createQuery("from Customer order by firstName asc", Customer.class);         
        }        
        return query.getResultList();
	}

}
