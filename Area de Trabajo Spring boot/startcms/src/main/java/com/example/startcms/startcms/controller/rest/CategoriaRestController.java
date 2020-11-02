package com.example.startcms.startcms.controller.rest;

import java.util.List;

import com.example.startcms.startcms.Repository.CategoriaRepository;
import com.example.startcms.startcms.model.Categoria;
import com.example.startcms.startcms.model.common.RepBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaRepository repository;

    @PutMapping
    @CacheEvict(value = "categoria", allEntries = true)
    public ResponseEntity<RepBase> save(@RequestBody @Validated Categoria categoria){
        return ResponseEntity.ok(new RepBase(repository.save(categoria)));
    }

    @PostMapping
    @CacheEvict(value = "categoria", allEntries = true)
    public ResponseEntity<RepBase> update(@RequestBody @Validated Categoria categoria){
        return ResponseEntity.ok(new RepBase(repository.update(categoria)));
    }

    @GetMapping
    @Cacheable(value = "categoria")
    public ResponseEntity<List<Categoria>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> finById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok(new RepBase(repository.deleteById(id)));
    }
}
