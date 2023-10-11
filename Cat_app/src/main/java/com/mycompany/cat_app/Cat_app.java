/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cat_app;

import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author gyuhee
 */
public class Cat_app {

    public static void main(String[] args) throws IOException {
        int option = -1;
        String[] options = {"1. ver gatos", "2. ver favoritos","3. salir"};

        do {

            String selected = (String) JOptionPane.showInputDialog(null, "cat java", "menu", JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            option = Arrays.asList(options).indexOf(selected);

            switch (option) {
                case 0:
                    CatService.showCat();
                    break;
                case 1:
                    CatService.showFavourites();
                    break;
                default:
                    break;
            }
        } while (option != 2);

    }
}
