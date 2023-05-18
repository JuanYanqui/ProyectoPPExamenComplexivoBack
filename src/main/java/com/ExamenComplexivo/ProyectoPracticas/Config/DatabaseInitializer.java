package com.ExamenComplexivo.ProyectoPracticas.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Configuration
//public class DatabaseInitializer {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @PostConstruct
//    public void initialize() {
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("import.sql"));
//        populator.execute(dataSource);
//    }
//
//}
