package com.example.demo.apis.department.service;
import com.example.demo.apis.department.model.Department;
import com.example.demo.apis.department.model.inputDepartment;
import com.example.demo.apis.department.repository.DepartmentRepository;
import com.example.demo.apis.employee.model.Employee;
import com.example.demo.common.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(String id){
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not exist with id" + id));
    }
    public Department createDepartment(inputDepartment dep){
        Department d=new Department();
        d.setDepartmentNum(0);
        d.setDepartmentMangerId(-1);
        d.setDepartmentMangerName(null);
        d.setDepartmentName(dep.getDepartmentName());
        d.setDepartmentDescription(dep.getDepartmentDescription());
        return departmentRepository.save(d);
    }

    public Department updateDepartment(String departmentName,inputDepartment dep){
        Department updateDepartment=departmentRepository.findById(departmentName).orElseThrow(() -> new ResourceNotFoundException("Department not exist with department name: " + departmentName));
        updateDepartment.setDepartmentName(dep.getDepartmentName());
        updateDepartment.setDepartmentDescription(dep.getDepartmentDescription());
        departmentRepository.save(updateDepartment);
        return updateDepartment;
    }
    public void deleteDepartment(String departmentName){
        Department department=departmentRepository.findById(departmentName).orElseThrow(() -> new ResourceNotFoundException("Department not exist with department name: " + departmentName));
        departmentRepository.delete(department);
    }

    public List<String> getAllDepartmentName(){
        return departmentRepository.getAllDepartName();
    }
}
