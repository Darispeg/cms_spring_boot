package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Comentario;

import org.springframework.jdbc.core.RowMapper;

public class ComentarioMapper implements RowMapper<Comentario> {

    @Override
    public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comentario comentario = new Comentario();
        comentario.setComentario(rs.getString("Comentario"));
        comentario.setFecha(rs.getDate("Fecha"));
        comentario.setIdComentario(rs.getInt("IdComentario"));
        comentario.setIdPost(rs.getInt("IdPost"));
        comentario.setIdUsuario(rs.getInt("IdUsuario"));
        comentario.setRespuesta(rs.getInt("Respuesta"));
        return comentario;
    }
}
