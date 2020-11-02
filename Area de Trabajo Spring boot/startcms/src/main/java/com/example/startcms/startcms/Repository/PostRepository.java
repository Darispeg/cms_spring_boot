package com.example.startcms.startcms.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.startcms.startcms.mapper.PostMapper;
import com.example.startcms.startcms.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements PostRep {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Post post) {
        try {
            String sql = String.format(
                    "INSERT INTO post(Titulo, Slug, Extracto, IdUsuario, Categoria, ImagenDestacada, Tipo) VALUES "
                    + "('%s', '%s', '%s', '%d', '%d', '%s', '%s')",
                    post.getTitulo(), post.getSlug(), post.getExtracto(), post.getIdUsuario(), post.getCategoria(),
                    post.getImagenDestacada(), post.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Post post) {
        if (post.getIdPost() > 0) {
            String sql = String.format(
                    "UPDATE post SET Titulo='%s', Slug='%s', Extracto='%s', ImagenDestacada='%s'"
                    + ", Tipo='%s' WHERE IdPost='%d'",
                    post.getTitulo(), post.getSlug(), post.getExtracto(), 
                    post.getImagenDestacada(), post.getTipo(), post.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Post> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM post", new PostMapper());
    }

    @Override
    public Post findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM post WHERE IdPost = ?", params, new PostMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
