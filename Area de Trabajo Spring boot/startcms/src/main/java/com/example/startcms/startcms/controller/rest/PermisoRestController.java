package com.example.startcms.startcms.controller.rest;

import java.util.List;

import com.example.startcms.startcms.Repository.PermisoRepository;
import com.example.startcms.startcms.model.Permiso;
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
@RequestMapping(value =  "/api/v1/permiso")
public class PermisoRestController {
    
    @Autowired
    private PermisoRepository repository;

    @PutMapping
    public ResponseEntity<RepBase> save(@RequestBody Permiso permiso){
        return ResponseEntity.ok(new RepBase(repository.save(permiso)));
    }

    @PostMapping
    public ResponseEntity<RepBase> update(@RequestBody Permiso permiso){
        return ResponseEntity.ok(new RepBase(repository.update(permiso)));
    }

    @GetMapping
    public ResponseEntity<List<Permiso>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> finById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
