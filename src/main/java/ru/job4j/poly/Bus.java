package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус выехал");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Кол-во пассажиров: " + passengers);
    }

    @Override
    public double refueling(int liters) {
        return liters * 50;
    }
}
