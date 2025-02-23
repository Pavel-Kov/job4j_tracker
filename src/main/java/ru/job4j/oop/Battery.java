package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery powerBank = new Battery(10);
        Battery smartphone = new Battery(5);
        System.out.print("Power bank: " + powerBank.load + "% ");
        System.out.println("Smartphone: " + smartphone.load + "%");
        powerBank.exchange(smartphone);
        System.out.print("Power bank: " + powerBank.load + "% ");
        System.out.println("Smartphone: " + smartphone.load + "%");
    }
}
