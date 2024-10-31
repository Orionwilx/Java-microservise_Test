/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmicroservice.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import java.net.InetSocketAddress;

/**
 *
 * @author Wilma
 */
public class CassandraConector {
    private CqlSession session;

    public void connect(String node, int port) {
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(node, port))
                .withLocalDatacenter("datacenter1") // Nombre de tu data center en Cassandra
                .build();
    }

    public CqlSession getSession() {
        return session;
    }

    public void close() {
        session.close();
    }
}
