/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gyuhee
 */
public class MessageDao {
    
    public static void createMessageDB(Message message){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            String query = "insert into mensajes (message, author_message) Values (?,?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getAuthor());
            ps.executeUpdate();
            System.out.println("created");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void readMessageDB(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                System.out.println("id: " + rs.getInt("id_message"));
                
                System.out.println("message: " + rs.getString("message"));
                System.out.println("author: " + rs.getString("author_message"));
                System.out.println("date: " + rs.getString("date_message")+"\n");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteMessageDB(int id_message){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            String query = "DELETE FROM mensajes WHERE id_message = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id_message);
            ps.executeUpdate();
            System.out.println("deleted");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void updateMessageDB(Message message){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            String query = "UPDATE mensajes SET message = ? WHERE id_message = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setInt(2, message.getId());
            ps.executeUpdate();
            System.out.println("updated");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
