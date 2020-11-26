package com.livraria.cadastrolivro.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionFactory {
//    @Value("${url}")
//    private String url;
//    @Value("${username}")
//    private String user;
//    @Value("${password}")
//    private String password;

//    @Autowired
//    private Environment env;

    private static final String URL = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String USER = "midori";
    private static final String PASSWORD = "root";

    @Autowired

    public Connection getConnection() {
        try	{
            return	DriverManager.getConnection(URL, USER, PASSWORD);

//            System.out.println("-----------" + url);
//            return	DriverManager.getConnection(url, user, password);

//            System.out.println("-----------" + env.getProperty("spring.datasource.url"));
//            return	DriverManager.getConnection(env.getProperty("spring.datasource.url"),
//                    env.getProperty("spring.datasource.username"),
//                    env.getProperty("spring.datasource.password"));

        }	catch	(SQLException e)	{
            throw new	RuntimeException(e);
        }
    }
}
