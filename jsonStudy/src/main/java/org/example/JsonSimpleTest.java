package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonSimpleTest {
    public static void main(String[] args) throws IOException, ParseException {
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

        BufferedReader br;
        if(conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        String result = br.readLine();

        br.close();  //버퍼드리더 닫기
        conn.disconnect(); //연결객체 닫기

        //System.out.println(result);
        //제이슨 문자열로 결과를 받았음 => 파싱필요
        JSONParser jp = new JSONParser();
        JSONObject jsonObject = (JSONObject) jp.parse(result);
        JSONArray arr = (JSONArray) jsonObject.get("data");
        //System.out.println(arr);
        for (Object o : arr) {
            JSONObject obj = (JSONObject) o;
            System.out.print(obj.get("id") + "\t");
            System.out.print(obj.get("facilityName") + "\t");
            System.out.print(obj.get("address") + "\t");
            System.out.print(obj.get("org") + "\t");
            System.out.print(obj.get("createdAt") + "\t");
            System.out.println(obj.get("phoneNumber"));
        }

    }
}
