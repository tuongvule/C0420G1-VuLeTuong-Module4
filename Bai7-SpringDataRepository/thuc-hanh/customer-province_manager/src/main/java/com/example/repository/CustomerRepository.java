package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAllByNameContaining( String name,Pageable pageable);
    Page<Customer> findAllByName(String name,Pageable pageable);
    Page<Customer> findAllByNameContainingOrAgeContainingOrProvinceContaining(String name, int age, String province, Pageable pageable);

}
