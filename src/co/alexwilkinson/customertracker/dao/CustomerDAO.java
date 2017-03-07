package co.alexwilkinson.customertracker.dao;

import java.util.List;

import co.alexwilkinson.customertracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);

}
