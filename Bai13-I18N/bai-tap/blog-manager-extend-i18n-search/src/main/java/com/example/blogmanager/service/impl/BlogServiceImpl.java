package com.example.blogmanager.service.impl;

import com.example.blogmanager.model.Blog;
import com.example.blogmanager.repository.BlogRepository;
import com.example.blogmanager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
