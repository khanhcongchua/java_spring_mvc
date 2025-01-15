package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(long id){
        this.productRepository.deleteById(id);
    }


    public List<Product> getAllProductsByName(String name){
        return this.productRepository.findOneByName(name);
    }






}
