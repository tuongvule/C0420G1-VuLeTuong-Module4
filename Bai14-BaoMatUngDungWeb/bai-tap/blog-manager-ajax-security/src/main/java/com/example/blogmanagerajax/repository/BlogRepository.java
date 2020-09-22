package com.example.blogmanagerajax.repository;

import com.example.blogmanagerajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAll(Pageable pageable);


//    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
//    List<Blog> findAllByNameContaining(String name);
    List<Blog> findAllByNameContainingOrContentContaining(String name, String content);
//    List<Blog> findAllByNameContainingAndContentContaining(String name);

    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
}
