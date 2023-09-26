/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.message_app;

import java.sql.Connection;

/**
 *
 * @author gyuhee
 */
public class Message_app {

    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        
        try (Connection cnx = conexion.get_connection()){
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
