package com.example.startcms.startcms.repository;

import com.example.startcms.startcms.Repository.UsuarioRepository;
import com.example.startcms.startcms.component.TestDatabaseConfiguration;
import com.example.startcms.startcms.model.Usuario;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class UsuarioRepositoryTest {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    Log log = LogFactory.getLog(getClass());

    @Test
    public void testInsertar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Gabriel");
        usuario.setApellido("Magne");
        usuario.setCorreo("gabriel@gmail.com");
        usuario.setContrasena("ninguna");
        usuario.setIdGrupo(1);

        boolean result = usuarioRepository.save(usuario);
        
        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testUpdate(){
        Usuario usuario = new Usuario();
        usuario.setNombre("NameUpdate");
        usuario.setApellido("LastName");
        usuario.setCorreo("Update");
        usuario.setContrasena("Update");
        usuario.setIdGrupo(2);
        usuario.setIdUsuario(2);

        boolean result = usuarioRepository.update(usuario);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testFinById(){
        Usuario usuario = usuarioRepository.findById(1);
        if(usuario == null){
            log.warn("Usuario Vacio");
        }
    }

    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        if(usuarioRepository.findAll(pageable).isEmpty()){
            log.warn("No hay ningun Usuario");
        }
    }
}
