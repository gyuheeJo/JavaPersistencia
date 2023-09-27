/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message_app;

/**
 *
 * @author gyuhee
 */
public class MessageService {
    public static void createMessage(String message, String author){
        Message data = new Message(message,author);
        MessageDao.createMessageDB(data);
    }
    public static void listMessage(){
        MessageDao.readMessageDB();
    }
    public static void deleteMessage(int id){
        MessageDao.deleteMessageDB(id);
    }
    public static void editMessage(String message, int id){
        Message data = new Message();
        data.setMessage(message);
        data.setId(id);
        MessageDao.updateMessageDB(data);
    }
}
