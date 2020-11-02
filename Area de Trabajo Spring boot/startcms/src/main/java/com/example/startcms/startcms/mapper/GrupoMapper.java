package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Grupo;

import org.springframework.jdbc.core.RowMapper;

public class GrupoMapper implements RowMapper<Grupo> {

    @Override
    public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(rs.getInt("IdGrupo"));
        grupo.setNOMBRE(rs.getString("NOMBRE"));
        return grupo;
    }
    
}
