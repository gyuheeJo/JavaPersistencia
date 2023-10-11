/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cat_app;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gyuhee
 */
public class CatService {

    public static void showCat() throws IOException {
        //Bringing data from the API
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();

        Response response = client.newCall(request).execute();

        String responseJSON = response.body().string();

        responseJSON = responseJSON.substring(1, responseJSON.length() - 1);

        Gson gson = new Gson();
        Cat cat = gson.fromJson(responseJSON, Cat.class);

        //Redimensionar
        Image image = null;

        try {
            URL url = new URL(cat.getUrl());
            image = ImageIO.read(url);

            ImageIcon catImage = new ImageIcon(image);

            if (catImage.getIconWidth() > 800) {
                Image background = catImage.getImage();
                Image modificated = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);

                catImage = new ImageIcon(modificated);
            }

            String buttons[] = {"see cat", "favorite", "go back"};
            String id = cat.getId();
            String selected = (String) JOptionPane.showInputDialog(null, "Menu", id, JOptionPane.INFORMATION_MESSAGE, catImage, buttons, buttons[0]);

            int option = -1;
            option = Arrays.asList(buttons).indexOf(selected);

            switch (option) {
                case 0:
                    showCat();
                    break;
                case 1:
                    favouriteCat(cat);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void favouriteCat(Cat cat) {

        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\"" + cat.getId() + "\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApikey())
                    .build();
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void showFavourites() throws IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "live_441pNC5wtfXk17Saoag2ewfo2aU9l3XPPEw7BproNee5rOjoslcLG1ZDvoic3x1X")
                .build();
        Response response = client.newCall(request).execute();

        String responseJSON = response.body().string();

        Gson gson = new Gson();

        CatFav[] favs = gson.fromJson(responseJSON, CatFav[].class);

        if (favs.length > 0) {
            int min = 1;
            int max = favs.length;
            int random = (int) (Math.random() * ((max - min) + 1)) + min;
            int index = random - 1;

            CatFav catFav = favs[index];

            //Redimensionar
            Image image = null;

            try {
                URL url = new URL(catFav.getImage().getUrl());
                image = ImageIO.read(url);

                ImageIcon catImage = new ImageIcon(image);

                if (catImage.getIconWidth() > 800) {
                    Image background = catImage.getImage();
                    Image modificated = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);

                    catImage = new ImageIcon(modificated);
                }

                String buttons[] = {"see Favourite cat", "delete Favourite", "go back"};
                String id = catFav.getId();
                String selected = (String) JOptionPane.showInputDialog(null, "Menu", id, JOptionPane.INFORMATION_MESSAGE, catImage, buttons, buttons[0]);

                int option = -1;
                option = Arrays.asList(buttons).indexOf(selected);

                switch (option) {
                    case 0:
                        showFavourites();
                        break;
                    case 1:
                        deleteFavourites(catFav);
                    default:
                        break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public static void deleteFavourites(CatFav catFav) throws IOException {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/" + catFav.getId())
                    .method("DELETE", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", catFav.getApikey())
                    .build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
