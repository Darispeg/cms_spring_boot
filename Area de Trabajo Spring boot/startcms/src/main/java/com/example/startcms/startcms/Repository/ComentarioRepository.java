package com.example.startcms.startcms.Repository;

import java.util.List;

import com.example.startcms.startcms.mapper.ComentarioMapper;
import com.example.startcms.startcms.model.Comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComentarioRepository implements ComentarioRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Comentario comentario){
        try {
            String sql = String.format(
                    "INSERT INTO comentario (Comentario, IdPost, IdUsuario, Respuesta) VALUES ('%s', '%d', '%d', '%d')",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Comentario comentario) {
        if (comentario.getIdComentario() > 0) {
            String sql = String.format(
                    "UPDATE comentario SET Comentario='%s', IdPost='%d', IdUsuario='%d', Respuesta='%d' WHERE IdComentario='%d'",
                    comentario.getComentario(),comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta(), comentario.getIdComentario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Comentario> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM comentario", new ComentarioMapper());
    }

    @Override
    public Comentario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM comentario WHERE IdComentario = ?", params, new ComentarioMapper());
    }
}
