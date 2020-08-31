package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> getAllCustomer( String name,Pageable pageable);

    void saveCustomer(Customer customer);

//    Page<Customer> getAllCustomerBySearch(String search);

    Page <Customer> getAllCustomerByName( String search,Pageable pageabl);
}
