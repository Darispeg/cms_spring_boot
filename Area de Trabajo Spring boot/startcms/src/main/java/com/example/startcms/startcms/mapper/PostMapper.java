package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Post;

import org.springframework.jdbc.core.RowMapper;

public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setCategoria(rs.getInt("Categoria"));
        post.setExtracto(rs.getString("Extracto"));
        post.setTitulo(rs.getString("Titulo"));
        post.setSlug(rs.getString("Slug"));
        post.setIdUsuario(rs.getInt("IdUsuario"));
        post.setIdPost(rs.getInt("IdPost"));
        post.setImagenDestacada(rs.getString("ImagenDestacada"));
        post.setTipo(rs.getString("Tipo"));
        return post;
    }
    
}
