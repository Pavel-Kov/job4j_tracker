package ru.job4j.oop.transport;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " летит по воздуху");
    }

    @Override
    public void speed() {
        System.out.println(" со скорростью 600 км/ч");
    }
}
