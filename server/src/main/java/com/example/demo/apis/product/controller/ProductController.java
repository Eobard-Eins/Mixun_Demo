package com.example.demo.apis.product.controller;


import com.example.demo.apis.employee.model.Employee;
import com.example.demo.apis.product.model.Product;
import com.example.demo.apis.product.repository.ProductRepository;
import com.example.demo.apis.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")//是用来处理跨源资源共享（CORS）的注解  *表示允许来自任意请求源的请求
@RestController//@RestController相当于指定类内部的@RequestMapping返回值都是json，就不需要添加@ResponseBody注解了
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Build get employees REST API
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Build create employee REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String time=formatter.format(date);
        product.setProductUpdateTime(time);
        return productService.createProduct(product);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product res = productService.getProductById(id);
        return ResponseEntity.ok(res);
    }

//    @GetMapping("{nameOrNum}")
//    public List<Product> getProductByNameOrNum(@PathVariable String nameOrNum){
//        return productService.getProductByNameOrNum(nameOrNum);
//    }
    // Build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product productDetails){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String time=formatter.format(date);
        productDetails.setProductUpdateTime(time);
        Product updateProduct = productService.updateProduct(id, productDetails);

        return ResponseEntity.ok(updateProduct);
    }

    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        productService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
