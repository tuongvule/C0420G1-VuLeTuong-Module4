package com.example.giohang.controller;

import com.example.giohang.model.Cart;
import com.example.giohang.model.Product;
import com.example.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;
    @ModelAttribute("cart")
    public Cart setUpUserForm(){
        return new Cart();
    }
    @GetMapping("/")
    public ModelAndView index(@PageableDefault(3) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search){
        Page <Product> products = productService.findAllByNameContaining(search,pageable);
        if(products.isEmpty()){
            return new ModelAndView("home","message","Not found product in database");
        }else {
            ModelAndView modelAndView = new ModelAndView("home","products",products);
            modelAndView.addObject(search);
            return modelAndView;
        }
    }
    @GetMapping("/viewProduct/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart){
    ModelAndView modelAndView = new ModelAndView("view", "product",productService.findById(id));
    modelAndView.addObject("cart",cart);
    return modelAndView;
    }
    @PostMapping("/addToCart/{id}")
    public ModelAndView addToCart(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        cart.addToCart(product);
        ModelAndView modelAndView = new ModelAndView("view","product",productService.findById(id));
        modelAndView.addObject("message","add " + product.getName() + " successfully");
        return modelAndView;
    }
    @GetMapping("/goToCart")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart){
        return new ModelAndView("cart","list",cart.getCart());
    }

    @GetMapping("/deleteProduct/{id}")
    public ModelAndView deleteFromCart(@ModelAttribute("cart") Cart cart, @PathVariable("id") Long id){
        cart.removeProduct(productService.findById(id));
        return new ModelAndView("cart", "list", cart.getCart());
    }
    @GetMapping("/decreaseFromCart/{id}")
    public ModelAndView decreaseFromCart(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        cart.decreaseFromCart(product);
        ModelAndView modelAndView = new ModelAndView("cart","list",cart.getCart());
//        modelAndView.addObject("message","add " + product.getName() + " successfully");
        return modelAndView;
    }
    @GetMapping("/increaseFromCart/{id}")
    public ModelAndView increaseFromCart(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        cart.increaseFromCart(product);
        ModelAndView modelAndView = new ModelAndView("cart","list",cart.getCart());
//        modelAndView.addObject("message","add " + product.getName() + " successfully");
        return modelAndView;
    }


}
