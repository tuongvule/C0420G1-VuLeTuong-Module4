package com.example.thuchanhsudungspringsecurity.repository;

import com.example.thuchanhsudungspringsecurity.model.AppUser;
import com.example.thuchanhsudungspringsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
