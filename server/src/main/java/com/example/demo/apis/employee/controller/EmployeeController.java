package com.example.demo.apis.employee.controller;


import com.example.demo.apis.employee.model.Employee;
import com.example.demo.apis.employee.repository.EmployeeRepository;
import com.example.demo.apis.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")//是用来处理跨源资源共享（CORS）的注解  *表示允许来自任意请求源的请求
@RestController//@RestController相当于指定类内部的@RequestMapping返回值都是json，就不需要添加@ResponseBody注解了
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Build get employees REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    // Build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getEmployeeNameById/{id}")
    public String getEmployeeNameByEmployeeId( @PathVariable long id){
        String employeeName = employeeService.getEmployeeNameByEmployeeId(id);
        return employeeName;
    }
    // Build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeService.updateEmployee(id,employeeDetails);

        return ResponseEntity.ok(updateEmployee);
    }

    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
