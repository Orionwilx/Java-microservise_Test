/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.time.LocalDate;


/**
 *
 * @author Wilma
 */
public class DaoComment {
    
    private final CqlSession session;

    public DaoComment(CqlSession session) {
        this.session = session;
    }

    // Método para insertar un comentario
    public void insertComment(int id, String description, int idclient, LocalDate datecomment) {
        String query = "INSERT INTO my_keyspace.comment (id, description, idclient, datecomment) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = session.prepare(query);
        session.execute(preparedStatement.bind(id, description, idclient, datecomment));
    }

    // Método para recuperar todos los comentarios
    public void getAllComments() {
        ResultSet resultSet = session.execute("SELECT * FROM my_keyspace.comment");
        for (Row row : resultSet) {
            System.out.println("ID: " + row.getInt("id"));
            System.out.println("Description: " + row.getString("description"));
            System.out.println("ID Client: " + row.getInt("idclient"));
            System.out.println("Date Comment: " + row.getLocalDate("datecomment"));
            System.out.println();
        }
    }
}
