package com.example.demo.apis.department.repository;

import com.example.demo.apis.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String>,JpaSpecificationExecutor{
    @Query(value = "select departmentName from departments",nativeQuery = true)
    public List<String> getAllDepartName();

}
