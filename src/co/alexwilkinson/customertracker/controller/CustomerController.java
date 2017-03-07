package co.alexwilkinson.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.alexwilkinson.customertracker.dao.CustomerDAO;
import co.alexwilkinson.customertracker.entity.Customer;
import co.alexwilkinson.customertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer service now instead of just the DAO
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model){
		
		//get customers
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add to the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		//model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		//save the customer in service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
		
		//get customer from the database
		Customer customer = customerService.getCustomers(id);
		
		//set customer as model attribute to pre-popuylate
		model.addAttribute("customer", customer);
		
		//send over to the form
		
		return "customer-form";
	}
	
}
