package com.example.blogmanager.controller;

import com.example.blogmanager.model.Blog;
import com.example.blogmanager.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView index(@PageableDefault(3) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search){
        Page <Blog> blogList = blogService.findAll(search,pageable);
        if(blogList.isEmpty()){
            return new ModelAndView("index","message","Not found blog in database");
        }else {
            ModelAndView modelAndView = new ModelAndView("index","blogs",blogList);
            modelAndView.addObject(search);
            return modelAndView;
        }

    }
    @GetMapping("/blog/create")
    public ModelAndView create(){
        return new ModelAndView("create","blog",new Blog());
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes attributes){
        attributes.addFlashAttribute("message", "saved blog successfully");
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Long id){
        Blog blog = blogService.findById(id);
        if(blog!=null){
            return new ModelAndView("edit","blog",blog);
        }else {
            return new ModelAndView("error.404");
        }

    }
    @PostMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","updated blog successfully");
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        Blog blog = blogService.findById(id);
        if(blog!=null){
            return new ModelAndView("delete","blog",blog);
        }else {
            return new ModelAndView("error.404");
        }

    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog,RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message","deleted blog successfully");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/view")
    public ModelAndView view(@PathVariable("id") Long id){
        return new ModelAndView("view","blog",blogService.findById(id));
    }
}
