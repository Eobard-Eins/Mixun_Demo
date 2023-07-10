package com.example.demo.apis.department.repository;

import com.example.demo.apis.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String>,JpaSpecificationExecutor{
    @Query(value = "select department_name from departments",nativeQuery = true)
    public List<String> getAllDepartName();
    @Modifying
    @Query(value = "update departments set department_num = :num where department_name = :name",nativeQuery = true)
    void updateNum(@Param("num") int num,@Param("name") String name);
}
