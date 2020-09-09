package com.example.demsoluotviewtrang.controller;

import com.example.demsoluotviewtrang.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myCounter")
// được sử dụng để lưu trữ model attribute trong session
public class CounterController {
    @ModelAttribute("myCounter")
    public MyCounter setUpMyCounter(){
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}
