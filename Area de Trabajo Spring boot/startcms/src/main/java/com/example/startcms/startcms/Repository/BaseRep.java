package com.example.startcms.startcms.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface BaseRep<T> {

    public boolean save(T Object);
    public boolean update(T object);
    public List<T> findAll(Pageable Pageable);
    public T findById(int Id);
}
