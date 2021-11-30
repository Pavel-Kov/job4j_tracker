package ru.job4j.oop.transport;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " едет по дороге");
    }

    @Override
    public void speed() {
        System.out.println(" со скорростью 60 км/ч");
    }
}
