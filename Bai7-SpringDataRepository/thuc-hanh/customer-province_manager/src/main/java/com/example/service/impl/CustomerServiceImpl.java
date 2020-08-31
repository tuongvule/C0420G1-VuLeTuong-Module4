package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page <Customer> getAllCustomer( String name,Pageable pageable) {
        return customerRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomerByName(String search, Pageable pageable) {
        return customerRepository.findAllByName(search, pageable);
    }
}
