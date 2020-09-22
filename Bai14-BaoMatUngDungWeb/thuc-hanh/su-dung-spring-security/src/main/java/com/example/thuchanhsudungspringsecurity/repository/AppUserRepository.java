package com.example.thuchanhsudungspringsecurity.repository;

import com.example.thuchanhsudungspringsecurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
