package com.example.security.demo_sercurity_2.controller;

import com.example.security.demo_sercurity_2.dao.RoleRepository;
import com.example.security.demo_sercurity_2.dao.UserRepository;
import com.example.security.demo_sercurity_2.entity.User;
import com.example.security.demo_sercurity_2.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private UserDetailsServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        return new ModelAndView("login");
    }

    @GetMapping("/loginSuccess")
    public ModelAndView success() {
        return new ModelAndView("loginSuccess");
    }

//    @PostMapping("/login")
//    public ModelAndView login(@RequestParam("username")String username, @RequestParam("password") String password) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username,password)
//        );
//        UserDetails userDetails = userServiceImpl
//                .loadUserByUsername(authentication.getName());
//        return new ModelAndView("loginSuccess");
//    }

    @GetMapping("/register")
    public ModelAndView viewRegister() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView viewRegister(@RequestParam("username") String username, @RequestParam("password") String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashPassword);
        user.setRole(roleRepository.findByRoleName("ROLE_USER"));
        userRepository.save(user);
        return new ModelAndView("login");
    }
}
