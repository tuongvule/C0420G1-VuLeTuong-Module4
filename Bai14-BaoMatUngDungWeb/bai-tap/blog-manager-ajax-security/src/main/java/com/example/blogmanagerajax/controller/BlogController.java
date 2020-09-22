package com.example.blogmanagerajax.controller;

import com.example.blogmanagerajax.model.Blog;
import com.example.blogmanagerajax.service.BlogService;
import com.example.blogmanagerajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin(origins = {"*"})
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@PageableDefault(value = 3) Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
//        public ModelAndView listBlogs(Pageable pageable){
//        Page<Blog> blogs = blogService.findAll(PageRequest.of(0,3));
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }



    @GetMapping ("/more")
    @ResponseBody
    public Page<Blog> listBlog1(@RequestParam(value = "numberOfPage", defaultValue = "3")int number, Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(PageRequest.of(0,number));
        return blogs;
    }

//    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<Blog> getListSearch(@RequestParam("search") String search){
////        List<Blog> listBlogs = blogService.findAllByNameContaining(search);
//        return null;
//    }

    @ResponseBody
    @RequestMapping(value ="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Blog> searchBlogs( @RequestParam(value = "search1")String search, @RequestParam(value = "search1") String content){
        List<Blog> blogs = blogService.findAllByNameContaining(search, content);
        return blogs;
    }


//    @GetMapping("/blogs")
//    public ModelAndView listBlogs(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search, @RequestParam(value = "searchCategogy",defaultValue = "all")String searchCategogy){
//        Page<Blog> blogs = null;
//        if ((search.equals("")) && searchCategogy.equals("all") ) {
//            blogs = blogService.findAll(pageable);
//        } else if(!search.equals("") && searchCategogy.equals("all")) {
//            blogs = blogService.findAllByNameContaining(search,pageable);
//        }else if (search.equals("") && !searchCategogy.equals("all")) {
//            blogs = blogService.findAllByCategory_Name(searchCategogy,pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("blog/list");
//        modelAndView.addObject("categorys", categoryService.findAll(pageable));
//        modelAndView.addObject("blogs", blogs);
//        modelAndView.addObject("search", search);
//        return modelAndView;
//    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlogs(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/create","blog",new Blog());
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog, @PageableDefault(value = 5) Pageable pageable) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("categorys", categoryService.findAll(Pageable.unpaged()));
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blogs updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-blog/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Blog blog = blogService.findById(id);
//        if(blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogService.remove(id);
        return "redirect:/blogs";
    }
}
