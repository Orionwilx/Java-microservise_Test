/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrest2;

/**
 *
 * @author Wilma
 */
public class Main {
    public static void main(String[] args) {
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
    }
}
