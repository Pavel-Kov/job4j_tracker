package ru.job4j.tracker.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        Calculator calculator = new Calculator();
        return sum(a) + minus(a) + calculator.multiply(a) + calculator.divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(minus(10));
        System.out.println(calculator.divide(20));
        System.out.println(calculator.sumAllOperation(20));
    }
}
