package com.example.quanlidienthoai.controller;

import com.example.quanlidienthoai.model.Smartphone;
import com.example.quanlidienthoai.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController {
    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/create")
    public ModelAndView createSmartphonePage(){
        return new ModelAndView("new-phone","sPhone",new Smartphone() );
    }

    @PostMapping(value = "/createnewPhone",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone){
        return smartphoneService.save(smartphone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones(){
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }



}
