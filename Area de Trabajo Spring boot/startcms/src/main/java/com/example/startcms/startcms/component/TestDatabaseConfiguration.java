package com.example.startcms.startcms.component;

import javax.sql.DataSource;

import com.example.startcms.startcms.Repository.CategoriaRepository;
import com.example.startcms.startcms.Repository.GrupoRepository;
import com.example.startcms.startcms.Repository.PermisoRepository;
import com.example.startcms.startcms.Repository.PostRepository;
import com.example.startcms.startcms.Repository.UsuarioRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Component;

//@Component
public class TestDatabaseConfiguration {
    
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/prueba_blog?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("q.yuD2EZF9iipkR");

        return dataSource;
    }

    @Bean
    public CategoriaRepository categoriaRepository(){
        return new CategoriaRepository();
    }

    @Bean
    public UsuarioRepository usuarioRepository(){
        return new UsuarioRepository();
    }

    @Bean
    public GrupoRepository grupoRepository(){
        return new GrupoRepository();
    }

    @Bean
    public PermisoRepository permisoRepository(){
        return new PermisoRepository();
    }

    @Bean
    public PostRepository postRepository(){
        return new PostRepository();
    }
}
