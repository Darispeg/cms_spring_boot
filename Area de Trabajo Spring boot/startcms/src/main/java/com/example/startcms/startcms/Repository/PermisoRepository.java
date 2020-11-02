package com.example.startcms.startcms.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.startcms.startcms.mapper.PermisoMapper;
import com.example.startcms.startcms.model.Permiso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PermisoRepository implements PermisoRep {
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Permiso permiso) {
        try {
            String sql = String.format(
                    "INSERT INTO permiso(NOMBRE) VALUES ('%s')",
                    permiso.getNOMBRE());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Permiso permiso) {
        if (permiso.getIdPermiso() > 0) {
            String sql = String.format(
                    "UPDATE permiso SET NOMBRE='%s' WHERE IdPermiso='%d'",
                    permiso.getNOMBRE(), permiso.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Permiso> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM permiso", new PermisoMapper());
    }

    @Override
    public Permiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM permiso WHERE IdPermiso = ?", params, new PermisoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
