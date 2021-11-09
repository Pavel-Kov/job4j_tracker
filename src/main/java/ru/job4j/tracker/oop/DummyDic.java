package ru.job4j.tracker.oop;

public class DummyDic {
    public String endToRus(String eng) {
        String str = "Неизвестное слово " + eng;
        return str;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        System.out.println(word.endToRus("Forest"));
    }
}
