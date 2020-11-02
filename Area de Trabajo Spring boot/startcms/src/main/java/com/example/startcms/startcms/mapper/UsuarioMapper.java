package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Usuario;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setApellido(rs.getString("Apellido"));
        usuario.setContrasena(rs.getString("Contrasena"));
        usuario.setCorreo(rs.getString("Correo"));
        usuario.setIdGrupo(rs.getInt("IdGrupo"));
        usuario.setIdUsuario(rs.getInt("IdUsuario"));
        usuario.setNombre(rs.getString("Nombre"));
        return usuario;
    }
    
}
