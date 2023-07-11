package com.example.demo.apis.product.service;

import com.example.demo.apis.employee.model.Employee;
import com.example.demo.common.ResourceNotFoundException;
import com.example.demo.apis.product.model.Product;
import com.example.demo.apis.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Build get All Products REST API
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Build create Product REST API
    public Product createProduct(Product product){

        return productRepository.save(product);
    }
    public Product getProductById(long id){
        Product res = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        return res;
    }
    // Build get Product by id REST API
    public List<Product> getProductByName(String NameOrNum){
        return productRepository.findProductByProductNameLike(NameOrNum);
    }

    // Build update Product REST API
    public Product updateProduct(long id, Product productDetails){
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id" + id));
        updateProduct.setProductName(productDetails.getProductName());
        updateProduct.setProductPrice(productDetails.getProductPrice());
        updateProduct.setProductSpecs(productDetails.getProductSpecs());
        updateProduct.setProductUpdateTime(productDetails.getProductUpdateTime());

        productRepository.save(updateProduct);
        return updateProduct;
    }

    // Build delete Product REST API
    public void deleteProduct(long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id" + id));

        productRepository.delete(product);
    }
}
