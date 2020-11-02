package com.example.startcms.startcms.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.startcms.startcms.mapper.GrupoMapper;
import com.example.startcms.startcms.model.Grupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GrupoRepository implements GrupoRep {
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Grupo grupo) {
        try {
            String sql = String.format(
                    "INSERT INTO grupo (NOMBRE) VALUES ('%s')",
                    grupo.getNOMBRE());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Grupo grupo) {
        if (grupo.getIdGrupo() > 0) {
            String sql = String.format(
                    "UPDATE grupo SET NOMBRE='%s' WHERE IdGrupo='%d'",
                    grupo.getNOMBRE(), grupo.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Grupo> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM grupo", new GrupoMapper());
    }

    @Override
    public Grupo findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM grupo WHERE IdGrupo = ?", params, new GrupoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
