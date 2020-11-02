package com.example.startcms.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.startcms.startcms.model.Permiso;

import org.springframework.jdbc.core.RowMapper;

public class PermisoMapper implements RowMapper<Permiso> {

    @Override
    public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(rs.getInt("IdPermiso"));
        permiso.setNOMBRE(rs.getString("NOMBRE"));
        return permiso;
    }
    
}
