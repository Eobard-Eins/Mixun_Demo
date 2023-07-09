package com.example.demo.apis.customer.controller;


import com.example.demo.apis.customer.model.Customer;
import com.example.demo.apis.customer.repository.CustomerRepository;
import com.example.demo.apis.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")//是用来处理跨源资源共享（CORS）的注解  *表示允许来自任意请求源的请求
@RestController//@RestController相当于指定类内部的@RequestMapping返回值都是json，就不需要添加@ResponseBody注解了
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    // Build get customers REST API
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // Build create customer REST API
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    // Build get customer by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/findByNameAndPhoneAndAddress/")
    public List<Customer> findCustomerByNameLikeAndPhoneLikeAndAddressLike (@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address")String address){
        return customerRepository.findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike("%"+name+"%","%"+phone+"%","%"+address+"%");
    }
    @GetMapping("/getCustomerNameById/{id}")
    public String getCustomerNameByCustomerId( @PathVariable long id){
        String customerName = customerService.getCustomerNameByCustomerId(id);
        return customerName;
    }
    // Build update customer REST API
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customerDetails){
        Customer updateCustomer = customerService.updateCustomer(id,customerDetails);

        return ResponseEntity.ok(updateCustomer);
    }

    // Build delete customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
