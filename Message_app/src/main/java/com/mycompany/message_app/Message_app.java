/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.message_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

/**
 *
 * @author gyuhee
 */
public class Message_app {

    public static void main(String[] args) throws IOException{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int option=0;
        int id;
        String m;
        do{
            System.out.print("1. create\n2. read\n3. delete\n4. update\n5. end\n");
            option = Integer.parseInt(in.readLine());
            
            switch (option) {
                case 1:
                    System.out.println("Message: ");
                    m = in.readLine();
                    System.out.println("Author: ");
                    String a = in.readLine();
                    MessageService.createMessage(m,a);
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    System.out.println("message_id: ");
                    id = Integer.parseInt(in.readLine());
                    MessageService.deleteMessage(id);
                    break;
                case 4:
                    System.out.println("message_id: ");
                    id = Integer.parseInt(in.readLine());
                    
                    System.out.println("message: ");
                    m = in.readLine();
                    MessageService.editMessage(m, id);
                    break;
                default:
                    break;
            }
        }while (option != 5);
        
        Conexion conexion = new Conexion();
        
        try (Connection cnx = conexion.get_connection()){
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
