package com.example.startcms.startcms.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.startcms.startcms.mapper.UsuarioMapper;
import com.example.startcms.startcms.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements UsuarioRep {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Usuario usuario) {
        try {
            String sql = String.format(
                    "INSERT INTO usuario (Nombre, Apellido, Contrasena, Correo, IdGrupo) VALUES ('%s', '%s', '%s', '%s', '%d')",
                    usuario.getNombre(), usuario.getApellido(), usuario.getContrasena(), usuario.getCorreo(),
                    usuario.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(Usuario usuario) {
        if (usuario.getIdUsuario() > 0) {
            String sql = String.format(
                    "UPDATE usuario SET Nombre='%s', Apellido='%s', Contrasena='%s', Correo='%s', IdGrupo='%d' "
                    + "WHERE IdUsuario='%d'",
                    usuario.getNombre(), usuario.getApellido(), usuario.getContrasena(), usuario.getCorreo(),
                    usuario.getIdGrupo(), usuario.getIdUsuario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll(Pageable Pageable) {
        return jdbcTemplate.query("SELECT * FROM usuario", new UsuarioMapper());
    }

    @Override
    public Usuario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE IdUsuario = ?", params, new UsuarioMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
