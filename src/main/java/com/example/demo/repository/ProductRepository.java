package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Product save(Product product);
    List<Product> findOneByName(String name);
    List<Product> findAll();
    Optional<Product> findById(long id);
    void deleteById(long id);
}
