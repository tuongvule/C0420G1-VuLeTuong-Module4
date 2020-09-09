package com.example.blogmanager.controller;

import com.example.blogmanager.model.Blog;
import com.example.blogmanager.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.PersistenceContext;
import java.util.List;

@RestController

public class BlogController {
    @Autowired
    BlogService blogService;

    //-------------------Retrieve All Blogs--------------------------------------------------------
    @GetMapping("/blogs/")
    public ResponseEntity<List<Blog>> listAllCustomers() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);

    }
    //-------------------Retrieve Single Blog--------------------------------------------------------
    @GetMapping(value = "/blogs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //-------------------Create a Blog--------------------------------------------------------
    @PostMapping("/blogs/")
    public ResponseEntity<Void> createCustomer(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Blog " + blog.getTitle());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Update a Blog--------------------------------------------------------
    @PutMapping("/blogs/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") long id, @RequestBody Blog blog){
        System.out.println("Updating Blog " + id);

        Blog currentBlog = blogService.findById(id);

        if(currentBlog==null){
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setId(blog.getId());
        currentBlog.setTitle(blog.getContent());
        currentBlog.setContent(blog.getContent());
        blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog,HttpStatus.OK);
    }

    //-------------------Delete a Blog--------------------------------------------------------
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id){
        System.out.println("Fetching & Deleting Blog with id " + id);

        Blog blog = blogService.findById(id);
        if(blog==null){
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);

    }


}
