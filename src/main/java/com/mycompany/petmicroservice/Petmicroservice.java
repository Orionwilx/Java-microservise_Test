/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.petmicroservice;

import com.mycompany.petmicroservice.postgrest2.ClientService;
import com.mycompany.petmicroservice.postgrestsql.Pet;
import com.mycompany.petmicroservice.postgrestsql.PetRepository;
import com.mycompany.petmicroservice.cassandra.CassandraConector;
import com.mycompany.petmicroservice.cassandra.DaoComment;
import java.util.List;
import java.time.LocalDate;



/**
 *
 * @author Wilma
 */
public class Petmicroservice {
    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository();

        // Agregar una mascota
        Pet pet = new Pet(2, "Buddy", "Dog");
        petRepository.addPet(pet);

        // Listar todas las mascotas
        List<Pet> pets = petRepository.getAllPets();
        for (Pet p : pets) {
            System.out.println(p.getName() + " - " + p.getType());
        }

        // Actualizar una mascota
        pet.setName("Max");
        petRepository.updatePet(pet);

        // Eliminar una mascota
        petRepository.deletePet(pet.getId());
        
        // Agregar un cliente
        ClientService.agregarCliente("Carlos", "Ramírez", "carlos.ramirez@example.com");

        // Obtener todos los clientes
        System.out.println("Lista de clientes:");
        ClientService.obtenerClientes();

        // Actualizar email de un cliente
        System.out.println("Actualizando email del cliente con ID 1...");
        ClientService.actualizarEmailCliente(1, "nuevo.email@example.com");

        // Obtener clientes actualizados
        System.out.println("Lista de clientes actualizada:");
        ClientService.obtenerClientes();

        // Eliminar un cliente
        System.out.println("Eliminando cliente con ID 1...");
        ClientService.eliminarCliente(1);

        // Obtener clientes después de eliminar
        System.out.println("Lista de clientes tras eliminar:");
        ClientService.obtenerClientes();
        
        
        CassandraConector connector = new CassandraConector();
        connector.connect("127.0.0.1", 9042); // IP y puerto de Cassandra

        DaoComment commentDAO = new DaoComment(connector.getSession());

        // Insertar un comentario
        commentDAO.insertComment(2, "This is a test comment wil estuvo aqui", 2, LocalDate.now());

        // Obtener todos los comentarios
        System.out.println("All comments:");
        commentDAO.getAllComments();

        connector.close();
    
    }
}
