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
	public List<Customer> getCustomers() {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastname",
																	Customer.class);
		
		//execute query
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer or update it id exists
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int id) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//read object from database using id
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//remove the object
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();

	}
	
	
	
	
	
	

}
