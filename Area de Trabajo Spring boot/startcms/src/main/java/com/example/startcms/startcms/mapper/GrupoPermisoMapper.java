package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.GrupoPermiso;

import org.springframework.jdbc.core.RowMapper;

public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

    @Override
    public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        GrupoPermiso grupoPermiso = new GrupoPermiso();
        grupoPermiso.setIdGrupo(rs.getInt("IdGrupo"));
        grupoPermiso.setIdPermiso(rs.getInt("IdPermiso"));
        return grupoPermiso;
    }
    
}
