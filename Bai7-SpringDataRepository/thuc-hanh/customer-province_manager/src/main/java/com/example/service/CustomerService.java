package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    Page<Customer> getAllCustomer( String name,Pageable pageable);

    void saveCustomer(Customer customer);

//    Page<Customer> getAllCustomerBySearch(String search);

    Page <Customer> getAllCustomerByName( String search,Pageable pageabl);

    Page<Customer> findAllByNameContainingOrAgeContainingOrProvinceContaining(String name, int age, String province, Pageable pageable);
}
