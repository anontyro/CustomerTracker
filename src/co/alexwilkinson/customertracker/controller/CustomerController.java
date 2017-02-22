package co.alexwilkinson.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showFormForAdd(Model themodel){
		return "customer-form";
	}
	
}
