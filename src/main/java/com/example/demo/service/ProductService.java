package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product handlSaveProduct(Product product){
        Product flower = this.productRepository.save(product);
        System.out.println(flower);
        return flower;
    }



    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }








}
