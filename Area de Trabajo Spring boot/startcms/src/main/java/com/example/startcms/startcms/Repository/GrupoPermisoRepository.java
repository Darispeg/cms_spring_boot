package com.example.startcms.startcms.Repository;

import java.util.List;

import com.example.startcms.startcms.mapper.GrupoPermisoMapper;
import com.example.startcms.startcms.model.GrupoPermiso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(GrupoPermiso grupoPermiso) {
        try {
            String sql = String.format(
                    "INSERT INTO grupo_permiso(IdGrupo, IdPermiso) VALUES ('%d', '%d')",
                    grupoPermiso.getIdGrupo(), grupoPermiso.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(GrupoPermiso grupoPermiso) {
        return false;
    }

    @Override
    public List<GrupoPermiso> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM grupo_permiso", new GrupoPermisoMapper());
    }

    @Override
    public GrupoPermiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM grupo_permiso WHERE IdGrupo = ?", params, new GrupoPermisoMapper());
    }
}
