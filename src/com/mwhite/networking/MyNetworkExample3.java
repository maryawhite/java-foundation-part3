package com.mwhite.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class MyNetworkExample3 {

    public static void main(String[] args) {
    // Set the default Authenticator with your username and password
    String username = "bfeeny238@hotmail.com";
    String password = "bill2020";
    setDefaultAuthenticator(username, password);

    // Define your path and query parameters separately
    String path = "/products/page/1";
    String queryParams = "sortField=name&sortDir=asc&categoryId=0";

    String jsonResponse = makeHttpRequestWithQueryParams("http://localhost:8080/ShopmeAdmin", path, queryParams);

    // Parse the JSON response
        if (jsonResponse != null) {
        JSONObject jsonObject = new JSONObject(jsonResponse);

        // Now you can access JSON data using the jsonObject
            //Check backend server for json object?
        String someValue = jsonObject.getString("someKey");
        int anotherValue = jsonObject.getInt("anotherKey");

        // Example for JSON array
        JSONArray jsonArray = jsonObject.getJSONArray("arrayKey");
    }
}

    private static void setDefaultAuthenticator(String username, String password) {
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });
    }

    private static String makeHttpRequestWithQueryParams(String baseUrl, String path, String queryParams) {
        try {
            // Create a URL object by combining baseUrl, path, and query parameters
            URL url = new URL(baseUrl + path + "?" + queryParams);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Read the response stream
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            // Don't forget to close the connection when you're done.
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            return null;
        }
    }


}
