package com.example.startcms.startcms.Repository;

import java.util.List;

import com.example.startcms.startcms.mapper.UsuarioMetadataMapper;
import com.example.startcms.startcms.model.UsuarioMetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(UsuarioMetadata Umetadata) {
        try {
            String sql = String.format(
                    "INSERT INTO usuario_metadata(IdUsuario, Clave, Valor, Tipo) VALUES ('%d', '%s', '%s', '%s')",
                    Umetadata.getIdUsuario(), Umetadata.getClave(), Umetadata.getValor(), Umetadata.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(UsuarioMetadata Umetadata) {
        if (Umetadata.getIdUsuarioMetadata() > 0) {
            String sql = String.format(
                    "UPDATE usuario_metadata SET IdUsuario='%d', Clave='%s', Valor='%s', Tipo='%s' WHERE IdUsuarioMetadata='%d'",
                    Umetadata.getIdUsuario(), Umetadata.getClave(), Umetadata.getValor(), Umetadata.getTipo(), 
                    Umetadata.getIdUsuarioMetadata());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<UsuarioMetadata> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM usuario_metadata", new UsuarioMetadataMapper());
    }

    @Override
    public UsuarioMetadata findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM usuario_metadata WHERE IdUsuarioMetadata = ?", params, new UsuarioMetadataMapper());
    }
}
