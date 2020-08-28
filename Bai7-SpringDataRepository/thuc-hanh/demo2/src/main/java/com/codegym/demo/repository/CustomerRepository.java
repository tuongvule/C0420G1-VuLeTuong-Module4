package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select c from Customer c where c.name = ")
    Page<Customer> getAllListCustomerByName(Pageable pageable,String name);


    Page<Customer> findAllByNameContainingOrProvince_NameContaining(String name, String nameProvince,Pageable pageable);


}
