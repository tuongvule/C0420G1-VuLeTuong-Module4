package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Guitar", "9000", "Martin, Japan", "Instrument"));
        products.put(2, new Product(2, "Flute", "3000", "Mao Meo, Viet Nam", "Instrument"));
        products.put(3, new Product(3, "Drum", "20000", "Yamaha, Japan", "Instrument"));
        products.put(4, new Product(4, "Ukulele", "4000", "Bejing, China", "Instrument"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product update(Integer id, Product product) {
        return products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
   products.remove(id);
    }

//    @Override
//    public List<Product> search(String name) {
//        List<Product> productList = new ArrayList<>(products.values());//duyệt trên list này
//        List<Product> products = new ArrayList<>();//tìm kiếm xong, trả về list này
//        for(i)
//
//    }
}
