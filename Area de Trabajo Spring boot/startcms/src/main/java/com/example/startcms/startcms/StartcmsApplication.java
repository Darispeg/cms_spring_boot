package com.example.startcms.startcms;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

@EnableCaching
@SpringBootApplication
public class StartcmsApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;


	public static void main(String[] args) {
		SpringApplication.run(StartcmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LogFactory.getLog(getClass()).info(environment.getProperty("spring.datasource.data-username"));
	}

}
