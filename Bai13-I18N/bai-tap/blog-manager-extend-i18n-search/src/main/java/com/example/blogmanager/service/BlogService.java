package com.example.blogmanager.service;

import com.example.blogmanager.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(String title, Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
