package com.example.userregisterform.controller;

import com.example.userregisterform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView showForm(){
        return new ModelAndView("index","user",new User());
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("index");
        }else {
            return new ModelAndView("result","user",user);
        }


    }
}
