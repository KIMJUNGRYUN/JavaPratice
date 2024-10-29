package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrgjsonTest {
    public static void main(String[] args) {
        /* 제이슨오브젝트 */
        JSONObject jo = new JSONObject();
        jo.put("id", 1234);
        jo.put("name", "길동");
        jo.put("email", "gilldong@gmail.com");

        System.out.println(jo.toString());

        Employee employee = new Employee(1234, "길동", "gilldong@gmail.com");
        JSONObject jo2 = new JSONObject(employee);
        System.out.println(jo2.toString());

        /* 제이슨어레이 배열 */
        Employee e1 = new Employee(1234, "길동", "gill@naver.com");
        Employee e2 = new Employee(1235, "펭수", "peng@naver.com");

        JSONObject j1 = new JSONObject(e1);
        JSONObject j2 = new JSONObject(e2);

        JSONArray emps = new JSONArray();
        emps.put(j1);
        emps.put(j2);

        JSONObject obj = new JSONObject();
        obj.put("employees", emps);

        System.out.println(obj.toString(2));
    }
}
