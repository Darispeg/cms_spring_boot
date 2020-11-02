package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.UsuarioMetadata;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioMetadataMapper implements RowMapper<UsuarioMetadata> {

    @Override
    public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioMetadata umetadata = new UsuarioMetadata();
        umetadata.setClave(rs.getString("Clave"));
        umetadata.setIdUsuario(rs.getInt("IdUsuario"));
        umetadata.setIdUsuarioMetadata(rs.getInt("IdUsuarioMetadata"));
        umetadata.setTipo(rs.getString("Tipo"));
        umetadata.setValor(rs.getString("Valor"));
        return umetadata;
    }
    
}
