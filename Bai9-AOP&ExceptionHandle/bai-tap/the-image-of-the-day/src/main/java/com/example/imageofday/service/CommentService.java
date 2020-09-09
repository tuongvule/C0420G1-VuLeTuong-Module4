package com.example.imageofday.service;

import com.example.imageofday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    Page<Comment> findAllByContentContaining(String content, Pageable pageable);

    Map<Integer,String> getList();
}
