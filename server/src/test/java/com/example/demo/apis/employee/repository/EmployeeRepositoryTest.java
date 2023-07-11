package com.example.demo.apis.employee.repository;

import com.example.demo.apis.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository es;
    @Test
    void countByEmployeeDepartment() {
        System.out.println(es.countByEmployeeDepartment("test"));
    }
}