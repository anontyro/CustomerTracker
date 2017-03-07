package co.alexwilkinson.customertracker.service;

import java.util.List;

import co.alexwilkinson.customertracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);
	

}
