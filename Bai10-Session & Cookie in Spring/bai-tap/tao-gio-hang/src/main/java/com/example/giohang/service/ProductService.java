package com.example.giohang.service;


import com.example.giohang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ProductService {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
}
