package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ParsingJson {
    public static void main(String[] args) {
        InputStream is = ParsingJson.class.getResourceAsStream("info.json");

        if(is == null){
            throw new NullPointerException("파일을 찾을 수 없음.");
        }
        //전체 제이슨 데이터를 토크너 객체로 받음
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        JSONArray emps = object.getJSONArray("employees");
        //제이슨 배열안에 있는 모든 제이슨객체의 정보를 출력!
        for(Object emp : emps){
            JSONObject employee = (JSONObject) emp;
            System.out.print(employee.get("id") + "\t");
            System.out.print(employee.get("name") + "\t");
            System.out.println(employee.get("email"));
        }

    }
}
