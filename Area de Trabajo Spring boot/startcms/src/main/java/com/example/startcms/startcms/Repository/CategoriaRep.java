package com.example.startcms.startcms.Repository;


import com.example.startcms.startcms.model.Categoria;


public interface CategoriaRep extends BaseRep<Categoria>{
    public boolean deleteById(int id);
}
