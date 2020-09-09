package com.example.quanlidienthoai.repository;

import com.example.quanlidienthoai.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
