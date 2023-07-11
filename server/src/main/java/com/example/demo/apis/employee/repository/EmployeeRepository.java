package com.example.demo.apis.employee.repository;

import com.example.demo.apis.customer.model.Customer;
import com.example.demo.apis.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>,JpaSpecificationExecutor {
    @Query(value = "select employee_name from employees where id = ?",nativeQuery = true)
    public String getEmployeeNameByEmployeeId(long id);
//    @Query(value = "select * from employees where = null", )

    public int countByEmployeeDepartment(String name);
    public List<Employee> findEmployeeByEmployeeNameLikeAndEmployeePhoneLikeAndEmployeeDepartmentLikeAndEmployeePosition(@Param("name") String name , @Param("phone") String phone , @Param("department") String department,@Param("position") String position );
}
