package com.example.demo.apis.product.service;

import com.example.demo.apis.product.model.Product;
import com.example.demo.apis.product.repository.ProductRepository;
import com.example.demo.utils.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productRepository;
    @Test
    void getAllProducts() {
        productRepository.getAllProducts();
    }

    @Test
    void createProduct() {
    }

    @Test
    void getProductByNameOrNum() {
        List<Product> lp=productRepository.getProductByNameOrNum("23");
        for (Product p:lp) System.out.println(p.getProductName());
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
        for(int i=1;i<10;i++){
            productRepository.deleteProduct(i);
        }
    }
}