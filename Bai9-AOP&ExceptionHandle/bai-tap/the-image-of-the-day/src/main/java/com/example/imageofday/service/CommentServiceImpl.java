package com.example.imageofday.service;

import com.example.imageofday.model.Comment;
import com.example.imageofday.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CommentServiceImpl implements CommentService{
    private static Map<Integer,String> listErrorCmt;
    static {
        listErrorCmt= new HashMap<>();
        listErrorCmt.put(1,"hai");
        listErrorCmt.put(2,"ba");
        listErrorCmt.put(3,"bon");
    }
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAllByContentContaining(String content, Pageable pageable) {
        return commentRepository.findAllByContentContaining(content,pageable);
    }

    @Override
    public Map<Integer, String> getList() {
        return listErrorCmt;
    }
}
