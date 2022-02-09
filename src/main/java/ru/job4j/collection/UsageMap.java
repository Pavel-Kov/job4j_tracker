package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("test1@test.ru", "Ivanov");
        map.put("test2@test.ru", "Petrov");
        map.put("test2@test.ru", "Petrov");
        map.put("test3@test.ru", "Sidorov");
        map.put("test3@test.ru", "Sidorov");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
