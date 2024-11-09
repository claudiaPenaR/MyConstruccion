package com.construccion.dao;

import java.sql.Connection;


public class DBConnectionTest {
    public static void main(String[] args) {
        try {
            // Intentar establecer la conexión
            Connection connection = DBConnection.getConnection();
            
            // Verificar si la conexión es válida
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexión a la base de datos exitosa.");
                connection.close(); // Cerrar la conexión después de la prueba
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            // Captura cualquier error de conexión y lo imprime
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
