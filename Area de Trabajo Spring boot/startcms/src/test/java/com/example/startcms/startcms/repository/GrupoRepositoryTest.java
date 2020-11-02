package com.example.startcms.startcms.repository;

import com.example.startcms.startcms.Repository.GrupoRepository;
import com.example.startcms.startcms.component.TestDatabaseConfiguration;
import com.example.startcms.startcms.model.Grupo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class GrupoRepositoryTest {
    
    @Autowired
    private GrupoRepository grupoRepository;

    Log log = LogFactory.getLog(getClass());

    @Test
    public void testInsert(){
        Grupo grupo = new Grupo();
        grupo.setNOMBRE("Celtas");
        
        boolean result = grupoRepository.save(grupo);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testUpdate(){
        Grupo grupo = new Grupo();
        grupo.setNOMBRE("Warriors");
        grupo.setIdGrupo(2);

        boolean result = grupoRepository.update(grupo);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testFinById(){
        Grupo grupo = grupoRepository.findById(1);

        if(grupo == null){
            log.warn("Grupo Vacio");
        }
        if("Raptors".equals(grupo.getNOMBRE())){
            log.info("Se encontro el Item: " + grupo.getNOMBRE());
        }
    }

    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        if(grupoRepository.findAll(pageable).isEmpty()){
            log.warn("No hay ningun Grupo");
        }
    }
}