package com.example.demo.apis.product.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository pr;
    @Test
    void findProductByProductNameLike() {
        System.out.println(pr.findProductByProductNameLike("%量子二踢%"));
    }
}