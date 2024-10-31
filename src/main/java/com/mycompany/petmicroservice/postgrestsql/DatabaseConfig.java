/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrestsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wilma
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/ipstest";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
    
    public void desconectar(Connection conn){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
                System.out.println("Conexion cerrada");
            }
        }catch(SQLException e){
            System.out.println("Error al cerrar Conexion" + e.getMessage());
        }
    }
}
