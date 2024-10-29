package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiTest {
    public static void main(String[] args) throws IOException {
        StringBuilder urlString =
                new StringBuilder("https://api.odcloud.kr/api/15077586/v1/centers");
        urlString.append("?" + "serviceKey" + "=982NxEgdH6thK%2FZDz70UrCfhK7oAZbmNwMC5vj%2Ftc9p7MhU5F9xBeJD47SMMIMfpvUbADVmpJPpZzqFqZDVwPg%3D%3D");
        urlString.append("&" + "page=1");
        urlString.append("&" + "perPage=10");
        //System.out.println(urlString);
        URL url = new URL(urlString.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response Code: " + conn.getResponseCode());
    }
}
