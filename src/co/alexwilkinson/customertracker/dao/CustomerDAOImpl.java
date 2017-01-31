package co.alexwilkinson.customertracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.alexwilkinson.customertracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//execute query
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customers
		return customers;
	}
	
	
	
	
	
	

}
