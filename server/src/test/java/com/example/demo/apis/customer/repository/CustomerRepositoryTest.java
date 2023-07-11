package com.example.demo.apis.customer.repository;

import com.example.demo.apis.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository cs;
    @Test
    void findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike() {
        System.out.println(cs.findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike("胡图图","%","%"));
    }
}