package com.example.blogmanagerajax.service;

import com.example.blogmanagerajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    public void save(Blog blog);
    public void remove(Long id);

    List<Blog> findAllByNameContaining(String name, String content);

    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);

}
