/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cat_app;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author gyuhee
 */
public class Cat_app {

    public static void main(String[] args) {
        int option = -1;
        String[] options = {"1. ver gatos", "2 salir"};
        
        do {

            String selected = (String) JOptionPane.showInputDialog(null, "cat java", "menu", JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            option = Arrays.asList(options).indexOf(selected);
        } while (option != 1);
        
        switch (option) {
            case 0:
                CatService.showCat();
                break;
            case 1:
                
                break;
            default:
                break;
        }

    }
}
