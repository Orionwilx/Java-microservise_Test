/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrestsql;

import java.util.List;

/**
 *
 * @author Wilma
 */
public class Main {
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
    }
}
