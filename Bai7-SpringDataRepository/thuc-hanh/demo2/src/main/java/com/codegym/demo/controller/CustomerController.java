package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getAllList(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,
                                   @RequestParam(value = "by", defaultValue = "all") String by) {

        Page<Customer> customerList = customerService.getAllCustomerBySearch(search,pageable);
        if (customerList.isEmpty()) {
            return new ModelAndView("customer/list", "message", "Không tìm thấy customer trong DB");
        } else {
            ModelAndView modelAndView= new ModelAndView("customer/list", "customers", customerList);
            modelAndView.addObject("search", search);
            return modelAndView;
        }
    }

    @GetMapping("/create-customer")
    public ModelAndView viewCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/create", "customer", new Customer());
        modelAndView.addObject("provinces", provinceService.getAllProvince());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        customerService.saveCustomer(customer);
        redirect.addFlashAttribute("message", "Customer "+customer.getName()+" đã tạo thành công");
        return "redirect:/customers";
    }
}
