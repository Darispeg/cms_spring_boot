package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Categoria;

import org.springframework.jdbc.core.RowMapper;

public class CategoriaMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria =  new Categoria();

        categoria.setCategoriaSuperior(rs.getInt("CategoriaSuperior"));
        categoria.setDescripcion(rs.getString("Descripcion"));
        categoria.setFechaCategoria(rs.getDate("FechaCategoria"));
        categoria.setIdCategoria(rs.getInt("IdCategoria"));
        categoria.setNombre(rs.getString("Nombre"));
        
        return categoria;
    }
    
}
