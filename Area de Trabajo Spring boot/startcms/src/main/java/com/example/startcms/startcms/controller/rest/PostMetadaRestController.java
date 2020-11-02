package com.example.startcms.startcms.controller.rest;

import java.util.List;

import com.example.startcms.startcms.Repository.PostMetadataRepository;
import com.example.startcms.startcms.model.PostMetadata;
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
@RequestMapping(value = "/api/v1/postmetadata")
public class PostMetadaRestController {
        
    @Autowired
    private PostMetadataRepository repository;

    @PutMapping
    public ResponseEntity<RepBase> save(@RequestBody PostMetadata postMetadata){
        return ResponseEntity.ok(new RepBase(repository.save(postMetadata)));
    }

    @PostMapping
    public ResponseEntity<RepBase> update(@RequestBody PostMetadata postMetadata){
        return ResponseEntity.ok(new RepBase(repository.update(postMetadata)));
    }

    @GetMapping
    public ResponseEntity<List<PostMetadata>> finAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostMetadata> finById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
