package com.example.blogmanagerajax.service.impl;

import com.example.blogmanagerajax.model.Blog;
import com.example.blogmanagerajax.repository.BlogRepository;
import com.example.blogmanagerajax.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
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

    @Override
    public List<Blog> findAllByNameContaining(String name, String content) {
        return blogRepository.findAllByNameContainingOrContentContaining(name, content);
    }

    @Override
    public Page<Blog> findAllByCategory_Name(String name, Pageable pageable) {
        return blogRepository.findAllByCategory_Name(name, pageable);
    }
}
