/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wilma
 */
public class ClientService {
    // Método para conectar a la base de datos demo_db
    private static Connection conectar() {
        Connection conexion = null;
        try {
            // Cambiamos el nombre de la base de datos a demo_db
            String url = "jdbc:postgresql://localhost:5432/demo_db";
            String usuario = "postgres";
            String password = "123456";
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a demo_db");
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        }
        return conexion;
    }

    // Método para crear un cliente
    public static void agregarCliente(String name, String lastname, String email) {
        String query = "INSERT INTO client (name, lastname, email) VALUES (?, ?, ?)";
        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println("Cliente agregado con éxito");
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    // Método para obtener todos los clientes
    public static void obtenerClientes() {
        String query = "SELECT * FROM client";
        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Nombre: " + name + ", Apellido: " + lastname + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    // Método para eliminar un cliente por su id
    public static void eliminarCliente(int id) {
        String query = "DELETE FROM client WHERE id = ?";
        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Cliente eliminado con éxito");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    // Método para actualizar el email de un cliente
    public static void actualizarEmailCliente(int id, String nuevoEmail) {
        String query = "UPDATE client SET email = ? WHERE id = ?";
        try (Connection conexion = conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, nuevoEmail);
            ps.setInt(2, id);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Email del cliente actualizado con éxito");
            } else {
                System.out.println("No se encontró un cliente con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        }
    }
}
