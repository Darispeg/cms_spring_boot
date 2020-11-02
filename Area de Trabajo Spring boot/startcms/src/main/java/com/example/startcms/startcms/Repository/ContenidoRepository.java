package com.example.startcms.startcms.Repository;

import java.util.List;

import com.example.startcms.startcms.mapper.ContenidoMapper;
import com.example.startcms.startcms.model.Contenido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContenidoRepository implements ContenidoRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Contenido contenido) {
        try {
            String sql = String.format(
                    "INSERT INTO contenido(Tipo, Contenido, IdPost) VALUES ('%s', '%s', '%d')",
                    contenido.getTipo(), contenido.getContenido(), contenido.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Contenido contenido) {
        if (contenido.getIdContenido() > 0) {
            String sql = String.format(
                    "UPDATE contenido SET Tipo='%s', Contenido='%s' WHERE IdContenido='%d'",
                    contenido.getTipo(), contenido.getContenido(), contenido.getIdPost(), contenido.getIdContenido());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Contenido> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM contenido", new ContenidoMapper());
    }

    @Override
    public Contenido findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM contenido WHERE IdContenido = ?", params, new ContenidoMapper());
    }
}
