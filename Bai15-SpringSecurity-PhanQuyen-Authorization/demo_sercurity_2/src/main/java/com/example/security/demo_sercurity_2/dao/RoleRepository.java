package com.example.security.demo_sercurity_2.dao;

import com.example.security.demo_sercurity_2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String role_name);
}
