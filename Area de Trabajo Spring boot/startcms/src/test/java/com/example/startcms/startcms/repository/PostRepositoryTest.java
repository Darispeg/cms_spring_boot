package com.example.startcms.startcms.repository;

import com.example.startcms.startcms.Repository.PostRepository;
import com.example.startcms.startcms.component.TestDatabaseConfiguration;
import com.example.startcms.startcms.model.Post;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    Log log = LogFactory.getLog(getClass());

    @Test
    public void testInsertar(){
        Post post = new Post();
        post.setCategoria(1);
        post.setExtracto("Ninguno");
        post.setIdUsuario(2);
        post.setImagenDestacada("imagenDestacada");
        post.setSlug("htpp:");
        post.setTipo("Destacado");
        post.setTipo("Test2");

        boolean result = postRepository.save(post);
        
        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testUpdate(){
        Post post = new Post();
        post.setCategoria(1);
        post.setExtracto("Ninguno");
        post.setIdUsuario(1);
        post.setImagenDestacada("imagenDestacada");
        post.setSlug("htpp:");
        post.setTipo("Destacado");
        post.setTitulo("Test2");
        post.setIdPost(1);

        boolean result = postRepository.update(post);
        
        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testFinById(){
        Post post = postRepository.findById(1);
        if(post == null){
            log.warn("Vacio");
        }
    }

    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        if(postRepository.findAll(pageable).isEmpty()){
            log.warn("No hay ningun Dato");
        }
    }
}
