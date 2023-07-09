package com.example.demo.apis.customer.repository;

import com.example.demo.apis.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>,JpaSpecificationExecutor {
    @Query(value = "select customer_name from customers where id = ?",nativeQuery = true)
    public String getCustomerNameByCustomerId(long id);
//    @Query(value = "select * from customers where = null", )


    public List<Customer> findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike(@Param("name") String name ,@Param("phone") String phone , @Param("address") String address );
}
