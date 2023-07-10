package com.example.demo.apis.employee.service;

import com.example.demo.apis.department.model.Department;
import com.example.demo.apis.department.repository.DepartmentRepository;
import com.example.demo.common.ResourceNotFoundException;
import com.example.demo.apis.employee.model.Employee;
import com.example.demo.apis.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    // Build get All employees REST API
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Build create employee REST API
    public Employee createEmployee(Employee employee){
        Employee e=employeeRepository.save(employee);
        departmentRepository.updateNum((int) employeeRepository.count(),e.getEmployeeDepartment());
        return e;
    }

    // Build get employee by id REST API
    public Employee getEmployeeById(long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        return employee;
    }
//    public List<employee> findEmployeeByNameLikeAndPhoneLikeAndAddressLike(String name,String phone,String address){
//        return employeeRepository.findEmployeeByNameLikeAndPhoneLikeAndAddressLike(name,phone,address);
//    }
    public String getEmployeeNameByEmployeeId(long id){
        String employeeName = employeeRepository.getEmployeeNameByEmployeeId(id);
        return employeeName;
    }
    // Build update employee REST API
    public Employee updateEmployee(long id, Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        String dep_old=updateEmployee.getEmployeeDepartment();
        String dep_new=employeeDetails.getEmployeeDepartment();


        updateEmployee.setEmployeeName(employeeDetails.getEmployeeName());
        updateEmployee.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
        updateEmployee.setEmployeePhone(employeeDetails.getEmployeePhone());
        updateEmployee.setEmployeePosition(employeeDetails.getEmployeePosition());

        employeeRepository.save(updateEmployee);
        return updateEmployee;
    }

    // Build delete employee REST API
    public void deleteEmployee(long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        String temp=employee.getEmployeeDepartment();
        employeeRepository.delete(employee);
        departmentRepository.updateNum((int) employeeRepository.count(),temp);
    }
}
