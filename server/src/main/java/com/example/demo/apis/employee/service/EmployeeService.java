package com.example.demo.apis.employee.service;

import com.example.demo.apis.customer.model.Customer;
import com.example.demo.apis.department.model.Department;
import com.example.demo.apis.department.repository.DepartmentRepository;
import com.example.demo.common.ResourceNotFoundException;
import com.example.demo.apis.employee.model.Employee;
import com.example.demo.apis.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<Employee> findEmployeeByEmployeeNameLikeAndEmployeePhoneLikeAndEmployeeDepartmentLikeAndEmployeePosition(String name ,String phone ,String department,String position ){
        return employeeRepository.findEmployeeByEmployeeNameLikeAndEmployeePhoneLikeAndEmployeeDepartmentLikeAndEmployeePosition(name,phone,department,position);
    }
    public Boolean existJingLi(String dep){
        Department d=departmentRepository.findById(dep).orElseThrow(() -> new ResourceNotFoundException("Department not exist with department name: " + dep));
        String s=d.getDepartmentMangerName();
        return s!=null;
    }

    // Build create employee REST API
    public Employee createEmployee(Employee employee){
        Employee e=employeeRepository.save(employee);
        String s=e.getEmployeeDepartment();
        if(employee.getEmployeePosition()=="经理"){
            departmentRepository.updateMangerId(employee.getId(),s);
            departmentRepository.updateMangerName(employee.getEmployeeName(),s);
        }
        departmentRepository.updateNum(employeeRepository.countByEmployeeDepartment(s),s);
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
        String oldtemp=updateEmployee.getEmployeePosition();
        String newtemp=employeeDetails.getEmployeePosition();
        if(!Objects.equals(dep_new, dep_old)){
            departmentRepository.updateNum(employeeRepository.countByEmployeeDepartment(dep_new),dep_new);
            departmentRepository.updateNum(employeeRepository.countByEmployeeDepartment(dep_old),dep_old);

        }
        if(oldtemp=="经理") {
            departmentRepository.updateMangerName(null,dep_old);
            departmentRepository.updateMangerId(null, dep_old);
        }
        if(newtemp=="经理"){
            departmentRepository.updateMangerId(employeeDetails.getId(),dep_new);
            departmentRepository.updateMangerName(employeeDetails.getEmployeeName(),dep_new);
        }

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
        departmentRepository.updateNum(employeeRepository.countByEmployeeDepartment(temp),temp);
        if(employee.getEmployeePosition()=="经理") {
            departmentRepository.updateMangerName(null,temp);
            departmentRepository.updateMangerId(null, temp);
        }
    }
}
