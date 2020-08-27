package com.example.blogmanager.controller;

import com.example.blogmanager.model.Blog;
import com.example.blogmanager.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceContext;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index","blogs",blogService.findAll());
    }
    @GetMapping("/blog/create")
    public ModelAndView create(){
        return new ModelAndView("create","blog",new Blog());
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes attributes){
        attributes.addFlashAttribute("success", "saved blog successfully");
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Long id){
        return new ModelAndView("edit","blog",blogService.findById(id));
    }
    @PostMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","updated blog successfully");
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        return new ModelAndView("delete","blog",blogService.findById(id));
    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog,RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success","deleted blog successfully");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/view")
    public ModelAndView view(@PathVariable("id") Long id){
        return new ModelAndView("view","blog",blogService.findById(id));
    }
}
