package com.example.startcms.startcms.repository;

import com.example.startcms.startcms.Repository.PermisoRepository;
import com.example.startcms.startcms.component.TestDatabaseConfiguration;
import com.example.startcms.startcms.model.Permiso;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PerimisoRepositoryTest {
    
    @Autowired
    private PermisoRepository permisoRepository;

    Log log = LogFactory.getLog(getClass());

    @Test
    public void testInsertar(){
        Permiso permiso = new Permiso();
        permiso.setNOMBRE("PermisoTest2");

        boolean result = permisoRepository.save(permiso);
        
        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testUpdate(){
        Permiso permiso = new Permiso();
        permiso.setNOMBRE("UpdateTestPermiso");
        permiso.setIdPermiso(2);
        boolean result = permisoRepository.update(permiso);

        if(!result){
            log.error("Ocurrio un error en el Test: " + result);
        }
    }

    @Test
    public void testFinById(){
        Permiso permiso = permisoRepository.findById(1);
        if(permiso == null){
            log.warn("Vacio");
        }
    }

    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        if(permisoRepository.findAll(pageable).isEmpty()){
            log.warn("No hay ningun Permiso");
        }
    }
}
