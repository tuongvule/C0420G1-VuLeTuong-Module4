package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;

import com.example.service.ProvinceService;
import com.fasterxml.jackson.annotation.JsonGetter;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //tìm kiếm tuyệt đối
    @GetMapping("/search")
    public ModelAndView searchCustomer(@PageableDefault(2) @RequestParam (value = "search", defaultValue = "") String search, Pageable pageable){
        Page<Customer> customerList = customerService.getAllCustomerByName(search,pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list","customers", customerList);
        if(customerList.isEmpty()){
            modelAndView.addObject("message","Not found customer in DB");
            return modelAndView;
        }else {
            modelAndView.addObject("search",search);//để hiển thị lại trên ô tìm kiếm
            return modelAndView;
        }
    }

    // tìm kiếm tuowng đối
    @GetMapping("/")
    public ModelAndView getAllList(@PageableDefault(2) Pageable pageable, @RequestParam (value = "search",defaultValue = "") String search){
        Page <Customer> customerList = customerService.getAllCustomer(search,pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");

        if(customerList.isEmpty()){
            modelAndView.addObject("customers",customerList);
            modelAndView.addObject("message","Not found customer in DB");
            return modelAndView;
        }else {
            modelAndView.addObject("customers",customerList);
            modelAndView.addObject("search",search);//để hiển thị lại trên ô tìm kiếm
            return modelAndView;
        }


    }

    // tìm kiếm tất cả các trường

    @GetMapping("/searchCustomerAllField")
    public ModelAndView searchCustomerAllField(@RequestParam(value = "name", defaultValue = "") String name,
                                               @RequestParam(value = "age", defaultValue = "") String age,
                                               @RequestParam(value = "province", defaultValue = "") String province,
                                               Pageable pageable){
        int ageParse;
        try {
            ageParse = Integer.parseInt(age);
        }catch (Exception ex){
            ageParse = 0;
            System.out.println(ex.getMessage());
        }

        Page<Customer> customerList = customerService.findAllByNameContainingOrAgeContainingOrProvinceContaining(name, ageParse, province, pageable);

        if(customerList.isEmpty()){
            return new ModelAndView("customer/list", "message", "Can't find customer in List");
        }else {
            ModelAndView modelAndView = new ModelAndView("customer/list", "customers",customerList);

            modelAndView.addObject("name", name);//để hiển thị lại trên ô tìm kiếm
            modelAndView.addObject("age", age);//để hiển thị lại trên ô tìm kiếm
            modelAndView.addObject("province", province);//để hiển thị lại trên ô tìm kiếm
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
