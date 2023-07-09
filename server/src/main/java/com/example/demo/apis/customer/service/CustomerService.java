package com.example.demo.apis.customer.service;

import com.example.demo.apis.customer.model.Customer;
import com.example.demo.apis.customer.repository.CustomerRepository;
import com.example.demo.common.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Build get All Customers REST API
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    // Build create customer REST API
    public Customer createCustomer(Customer customer){

        return customerRepository.save(customer);
    }

    // Build get customer by id REST API
    public Customer getCustomerById(long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id" + id));
        return customer;
    }

    public String getCustomerNameByCustomerId(long id){
        String customerName = customerRepository.getCustomerNameByCustomerId(id);
        return customerName;
    }
    // Build update customer REST API
    public Customer updateCustomer(long id, Customer customerDetails){
        Customer updateCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id" + id));
        updateCustomer.setCustomerName(customerDetails.getCustomerName());
        updateCustomer.setCustomerPhone(customerDetails.getCustomerPhone());
        updateCustomer.setCustomerAddress(customerDetails.getCustomerAddress());

        customerRepository.save(updateCustomer);
        return updateCustomer;
    }

    // Build delete customer REST API
    public void deleteCustomer(long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id" + id));

        customerRepository.delete(customer);
    }
}
