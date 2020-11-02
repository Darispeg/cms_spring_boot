package com.example.startcms.startcms.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.startcms.startcms.mapper.CategoriaMapper;
import com.example.startcms.startcms.model.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository implements CategoriaRep {
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Categoria categoria) {
        try {
            String sql = String.format(
                    "INSERT INTO categoria (Nombre, Descripcion, CategoriaSuperior) " + "VALUES ('%s', '%s', %d)",
                    categoria.getNombre(), categoria.getDescripcion(), categoria.getCategoriaSuperior());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Categoria categoria) {
        if (categoria.getIdCategoria() > 0) {
            String sql = String.format(
                    "UPDATE categoria SET Nombre='%s', Descripcion='%s' WHERE IdCategoria='%d'",
                    categoria.getNombre(), categoria.getDescripcion(), categoria.getIdCategoria());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Categoria> findAll(Pageable pageable) {
        return jdbcTemplate.query("SELECT * FROM categoria", new CategoriaMapper());
    }

    @Override
    public Categoria findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM categoria WHERE IdCategoria = ?", params, new CategoriaMapper());
    }

    public void deleteAll(){
        jdbcTemplate.execute("DELETE FROM categoria");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean deleteById(int id) {
        try {
            String sql = String.format("delete from categoria where IdCategoria='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
