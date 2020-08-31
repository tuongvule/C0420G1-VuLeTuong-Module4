package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;

import com.example.service.ProvinceService;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/customers")
    public ModelAndView getAllList(@PageableDefault(2) Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        Page <Customer> customerList = customerService.getAllCustomer(search,pageable);
        if(customerList.isEmpty()){
            return new ModelAndView("customer/list", "message", "Not found customer in DB");
        }else {
            ModelAndView modelAndView = new ModelAndView("customer/list","customers", customerList);
            modelAndView.addObject("search",search);
            return modelAndView;
        }
    }

    @GetMapping("/search")
    public ModelAndView searchCustomer(@RequestParam (value = "search", defaultValue = "") String search, Pageable pageable){
        Page<Customer> customerList = customerService.getAllCustomerByName(search,pageable);
        if(customerList.isEmpty()){
            return new ModelAndView("customer/list", "message", "Not found customer in DB");
        }else {
            ModelAndView modelAndView = new ModelAndView("customer/list","customers", customerList);
            modelAndView.addObject("search",search);
            return modelAndView;
        }
    }

    @GetMapping("/create-customer")
    public ModelAndView viewCreateCustomer(){
        ModelAndView modelAndView =  new ModelAndView("customer/create", "customer", new Customer());
        modelAndView.addObject("provinces", provinceService.getAllProvince());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes){
        attributes.addFlashAttribute("message","created customer: "+ customer.getName() + " successfully");
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

}
