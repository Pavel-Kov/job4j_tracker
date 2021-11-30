package ru.job4j.oop.transport;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " едет по рельсам");
    }

    @Override
    public void speed() {
        System.out.println(" со скорростью 80 км/ч");
    }
}
