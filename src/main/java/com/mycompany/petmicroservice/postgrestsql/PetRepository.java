/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrestsql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Wilma
 */
public class PetRepository {
    public void addPet(Pet pet) {
        Connection conn = DatabaseConfig.getConnection();
        String sql = "INSERT INTO pet (name, gener) VALUES (?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.executeUpdate();
            System.out.println("Pet added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        Connection conn = DatabaseConfig.getConnection();
        String sql = "SELECT * FROM pet";

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("gener");
                Pet pet = new Pet(id, name, type);
                pets.add(pet);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving pets: " + e.getMessage());
        }
        return pets;
    }

    public void deletePet(int id) {
        Connection conn = DatabaseConfig.getConnection();
        String sql = "DELETE FROM pet WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Pet deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting pet: " + e.getMessage());
        }
    }

    public void updatePet(Pet pet) {
        Connection conn = DatabaseConfig.getConnection();
        String sql = "UPDATE pet SET name = ?, gener = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getId());
            statement.executeUpdate();
            System.out.println("Pet updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating pet: " + e.getMessage());
        }
    }
}
