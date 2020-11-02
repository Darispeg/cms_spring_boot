package com.example.startcms.startcms.repository;

import java.util.Date;

import com.example.startcms.startcms.Repository.CategoriaRepository;
import com.example.startcms.startcms.component.TestDatabaseConfiguration;
import com.example.startcms.startcms.model.Categoria;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRepositoryTest {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    Log log = LogFactory.getLog(getClass());

    @Test
    public void testInsert(){
        Categoria categoria = new Categoria();
        categoria.setNombre("Test5");
        categoria.setFechaCategoria(new Date());
        categoria.setDescripcion("Este es un ejemplo de categoria superior");
        categoria.setCategoriaSuperior(1);

        boolean result = categoriaRepository.save(categoria);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testUpdate(){
        Categoria categoria = new Categoria();
        categoria.setNombre("Cambio Test");
        categoria.setDescripcion("Se modifico en el test");
        categoria.setIdCategoria(3);

        boolean result = categoriaRepository.update(categoria);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testFinById(){
        Categoria categoria = categoriaRepository.findById(3);
        if(categoria== null){
            log.warn("Categoria Vacia");
        }
    }

    @Test
    public void testFinAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        if(categoriaRepository.findAll(pageable).isEmpty()){
            log.warn("No hay ninguna Categoria");
        }
    }
}
