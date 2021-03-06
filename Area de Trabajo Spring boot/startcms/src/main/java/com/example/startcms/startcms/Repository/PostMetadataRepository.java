package com.example.startcms.startcms.Repository;

import java.util.List;

import com.example.startcms.startcms.mapper.PostMetadataMapper;
import com.example.startcms.startcms.model.PostMetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostMetadataRepository implements PostMetadataRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(PostMetadata postMetadata) {
        try {
            String sql = String.format(
                    "INSERT INTO post_metadata(Clave, Valor, Tipo, IdPost) VALUES ('%s', '%s', '%s', '%d')",
                    postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(PostMetadata postMetadata) {
        if (postMetadata.getIdPostMetadata() > 0) {
            String sql = String.format(
                    "UPDATE post_metadata SET Clave='%s', Valor='%s', Tipo='%s' WHERE IdPostMetadata='%d'",
                    postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIdPostMetadata());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<PostMetadata> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM post_metadata", new PostMetadataMapper());
    }

    @Override
    public PostMetadata findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM post_metadata WHERE IdPostMetadata = ?", params, new PostMetadataMapper());
    }
}
