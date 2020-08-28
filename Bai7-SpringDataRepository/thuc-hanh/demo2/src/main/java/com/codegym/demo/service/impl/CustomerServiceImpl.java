package com.codegym.demo.service.impl;

import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.CustomerRepository;
import com.codegym.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
       return customerRepository.findAll(pageable);

    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomerBySearch(String search,Pageable pageable) {
        return customerRepository.findAllByNameContainingOrProvince_NameContaining(search,search,pageable);
    }
}
