package com.example.security.demo_sercurity_2.service;

import com.example.security.demo_sercurity_2.dao.RoleRepository;
import com.example.security.demo_sercurity_2.dao.UserRepository;
import com.example.security.demo_sercurity_2.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.example.security.demo_sercurity_2.entity.User appUser = this.userRepository.findByUsername(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
       Role roleNames =appUser.getRole();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
                GrantedAuthority authority = new SimpleGrantedAuthority(roleNames.getRoleName());
                grantList.add(authority);

        UserDetails userDetails =  new User(appUser.getUsername(), //
                appUser.getPassword(), grantList);

        return userDetails;
    }

}
