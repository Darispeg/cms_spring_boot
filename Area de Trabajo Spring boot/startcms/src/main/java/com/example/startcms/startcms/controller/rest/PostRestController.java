package com.example.startcms.startcms.controller.rest;

import java.util.List;

import com.example.startcms.startcms.Repository.PostRepository;
import com.example.startcms.startcms.model.Post;
import com.example.startcms.startcms.model.common.RepBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/post")
public class PostRestController {
    
    @Autowired
    private PostRepository repository;

    @PutMapping
    public ResponseEntity<RepBase> save(@RequestBody Post post){
        return ResponseEntity.ok(new RepBase(repository.save(post)));
    }

    @PostMapping
    public ResponseEntity<RepBase> update(@RequestBody Post post){
        return ResponseEntity.ok(new RepBase(repository.update(post)));
    }

    @GetMapping
    public ResponseEntity<List<Post>> finAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> finById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
