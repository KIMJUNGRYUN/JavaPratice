package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();

        /* 자바객체를 제이슨 문자열로 변환 */
        Employee emp = new Employee(1234, "홍길동", "gilldong@google.com");
        System.out.println(emp);

        String jsonString = gson.toJson(emp);
        System.out.println(jsonString);

        /* 제이슨문자열 데이터를 받아서 자바객체로 변환하기 */
        String inputData = "{\"id\":1234,\"name\":\"홍길동\",\"email\":\"gilldong@google.com\"}";
        Employee e = gson.fromJson(inputData, Employee.class);
        System.out.println(e);

        /* 자바 리스트를 제이슨 변환 */
        Employee e1 = new Employee(1234, "길동", "gilldong@google.com");
        Employee e2 = new Employee(1235, "펭수", "peng@google.com");

        List<Employee> employees = Arrays.asList(e1, e2);
        String jsonData = gson.toJson(employees);
        System.out.println(jsonData);

        /* 제이슨 리스트를 다시 자바 리스트로 */
        List<Employee> list = gson.fromJson(jsonData, List.class);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}
