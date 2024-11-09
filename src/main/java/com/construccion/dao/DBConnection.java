package com.construccion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try {
            properties.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new SQLException("Error de conexión a la base de datos", e);
        }
    }
}

