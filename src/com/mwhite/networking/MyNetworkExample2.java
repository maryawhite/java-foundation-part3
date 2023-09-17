package com.mwhite.networking;

import java.io.IOException;
import java.net.*;

/** To use this, you would need a server running. For example, I have another application
 * that runs on localhost:8080 that is running while I run this application.
 * */
public class MyNetworkExample2 {

    public static void main(String[] args) {
        String username = "bfeeny238@hotmail.com"; //not a real username, do not expose usernames/passwords in real life.
        String password = "bill2020";   //not a real password, do not expose passwords in real life.
        setDefaultAuthenticator(username, password);

        try{
            URL baseUrl = new URL("http://localhost:8080/ShopmeAdmin");
            String path = "/products/page/1";
            String query = "?sortField=name&sortDir=asc&categoryId=0";
            makeHttpRequestWithQueryParams(baseUrl, path, query);
        } catch (MalformedURLException me) {
            me.printStackTrace();
        }

    }

    private static void makeHttpRequestWithQueryParams(URL baseUrl, String path, String queryParams) {
        try{
            URL url = new URL(baseUrl + path + queryParams);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Connecting to: " + url);
            System.out.println("Timeout set: " + connection.getConnectTimeout() + " milliseconds");

            System.out.println("request method is: " + connection.getRequestMethod());
            System.out.println("response code is: " + connection.getResponseCode());
            System.out.println("response message: " + connection.getResponseMessage());

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
            e.printStackTrace();
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
