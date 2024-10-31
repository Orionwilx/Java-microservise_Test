/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.postgrestsql;

/**
 *
 * @author Wilma
 */
public class Pet {
    private int id;
    private String name;
    private String gener;

    public Pet(int id, String name, String gener) {
        this.id = id;
        this.name = name;
        this.gener = gener;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return gener; }
    public void setType(String type) { this.gener = type; }
}
