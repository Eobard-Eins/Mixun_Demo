package com.example.demo.apis.product.controller;

import com.example.demo.apis.product.model.Product;
import com.example.demo.apis.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductService Service;
    @Test
    void getAllProducts() {
        List<Product> lp=Service.getAllProducts();
        for(Product p:lp){
            System.out.println(p.getProductName());
        }
    }

    @Test
    void createProduct() {
        for(int i=0;i<10000;i++){
            String s= String.valueOf(i);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String time=formatter.format(date);
            Product p=new Product();
            p.setId(10000+i);
            p.setProductName("test"+s);
            p.setProductUpdateTime(time);
            p.setProductPrice(1000.00);
            System.out.println(Service.createProduct(p));
        }
    }

    @Test
    void getProductByNameOrNum() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteEmployee() {
    }
}