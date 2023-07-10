package com.example.demo.apis.department.service;
import com.example.demo.apis.department.model.Department;
import com.example.demo.apis.department.repository.DepartmentRepository;
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

    public Department createDepartment(Department dep){
        return departmentRepository.save(dep);
    }

    public Department updateDepartment(String departmentName,Department dep){
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
