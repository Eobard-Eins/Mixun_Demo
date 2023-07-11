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

    public List<Product> findProductByProductNameLike(@Param("temp") String name);


}
