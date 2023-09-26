/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gyuhee
 */
public class Conexion {
    
    public Connection get_connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/message_app","root","");
            if (connection != null){
                System.out.println("successful connection!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    
    
}
