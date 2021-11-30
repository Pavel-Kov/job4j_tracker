package ru.job4j.oop.transport;

public class Transport {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();

        Vehicle[] transport = new Vehicle[]{bus, airplane, train};
        for (Vehicle t : transport) {
            t.move();
            t.speed();
        }
    }
}
