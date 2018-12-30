package com.graetpro.library.cloudmusicapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    private String getMethod(String url) throws IOException {
        URL restURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            return line;
        }

        br.close();
        return null;
    }
    public static String get(String x){
        Request restUtil = new Request();
        try {
            return restUtil.getMethod(x);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
