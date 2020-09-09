package com.example.taocookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/createCookie")
    public String createCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("userName","Tuong");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "home";
    }

    @GetMapping("/getCookie")
    public String getCookie(@CookieValue (name = "userName") String userName, Model model){
        model.addAttribute("cookieUser", userName);
        return "getCookie";
    }

    @GetMapping("/updateCookie")
    public String updateCookie(Model model, HttpServletResponse response, HttpServletRequest request){
        Cookie cookie = new Cookie("userName", "NhatHuy");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "getCookie";
    }

    @GetMapping("/deleteCookie")
    public String deleteCookie(Model model, HttpServletResponse response, HttpServletRequest request){
        Cookie cookie = new Cookie("userName", "Tuong");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "getCookie";
    }
}

