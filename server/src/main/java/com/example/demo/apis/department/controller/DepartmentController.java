package com.example.demo.apis.department.controller;
import com.example.demo.apis.customer.model.Customer;
import com.example.demo.apis.customer.repository.CustomerRepository;
import com.example.demo.apis.customer.service.CustomerService;
import com.example.demo.apis.department.model.Department;
import com.example.demo.apis.department.repository.DepartmentRepository;
import com.example.demo.apis.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public  List<Department> getAllDepartments(){return departmentService.getAllDepartment();}
    @PostMapping
    public Department createDepartment(@RequestBody Department dep){return departmentService.createDepartment(dep);}

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id,@RequestBody Department department){
        Department res=departmentService.updateDepartment(id,department);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable String id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
