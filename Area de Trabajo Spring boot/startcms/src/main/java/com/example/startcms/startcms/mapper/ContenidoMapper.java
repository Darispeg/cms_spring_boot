package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Contenido;

import org.springframework.jdbc.core.RowMapper;

public class ContenidoMapper implements RowMapper<Contenido> {

    @Override
    public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contenido contenido = new Contenido();
        contenido.setContenido(rs.getString("Contenido"));
        contenido.setIdContenido(rs.getInt("IdContenido"));
        contenido.setIdPost(rs.getInt("IdPost"));
        contenido.setTipo(rs.getString("Tipo"));
        return contenido;
    }
    
}
