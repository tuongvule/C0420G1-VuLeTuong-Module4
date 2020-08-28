package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> getAllCustomer(Pageable pageable);

    void saveCustomer(Customer customer);

    Page<Customer> getAllCustomerBySearch(String search,Pageable pageable);
}
