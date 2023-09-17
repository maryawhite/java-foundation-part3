package com.mwhite.networking;

import java.io.IOException;
import java.net.*;

/** To use this, you would need a server running. For example, I have another application
 * that runs on localhost:8080 that is running while I run this application.
 * */
public class MyNetwork {

    public static void main(String[] args) throws IOException {
        String username = "bfeeny238@hotmail.com";  //not a real username, do not expose usernames/passwords in real life.
        String password = "bill2020";               //not a real pw, do not expose usernames/passwords in real life.
        setDefaultAuthenticator(username, password);

        try{
            URL url = new URL("http://localhost:8080/ShopmeAdmin");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("request method is: " + connection.getRequestMethod());  //request method is: GET
            System.out.println("response code is: " + connection.getResponseCode());    //response code is: 200
            System.out.println("response message: " + connection.getResponseMessage()); //response message: null

        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    private static void setDefaultAuthenticator(String username, String password) {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        });
    }
}
