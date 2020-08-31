package com.example.customvalidation.controller;

import com.example.customvalidation.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public ModelAndView showForm(){
        return new ModelAndView("index","phoneNumber",new PhoneNumber());
    }

    @PostMapping("/validatePhone")
    public String checkValidation(@Validated @ModelAttribute ("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasErrors()){
            return "index";
        }else {
            model.addAttribute("phoneNumber",phoneNumber);
            return "result";
        }

    }
}
