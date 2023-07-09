package com.example.demo.apis.product.repository;

import com.example.demo.apis.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>,JpaSpecificationExecutor {
    @Query(value = "select * from products where product_name = :temp or product_num = :temp",nativeQuery = true)
    public List<Product> getProductByProductNameOrProductNum(@Param("temp") String nameOrNum);
//    @Query(value = "select * from employees where = null", )

}
