package com.mwhite;

import java.io.IOException;
import java.net.*;

public class MyNetwork {

    public static void main(String[] args) {
        String username = "bfeeny238@hotmail.com";
        String password = "bill2020";
        setDefaultAuthenticator(username, password);

        try{
            URL baseUrl = new URL("http://localhost:8080/ShopmeAdmin");
            String query = "/products/page/1?sortField=name&sortDir=asc&categoryId=0";
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            URI uri = new URI(baseUrl.getProtocol(), baseUrl.getHost(), baseUrl.getPath(), query, null);

            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            System.out.println("request method is: " + connection.getRequestMethod());
            System.out.println("response code is: " + connection.getResponseCode());
            System.out.println("response message: " + connection.getResponseMessage());

            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            System.out.println("An error occurred " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred.");
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
