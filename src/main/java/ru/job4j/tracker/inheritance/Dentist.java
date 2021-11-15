package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private int roomNumber;

    public Dentist(
            String name,
            String surname,
            String education,
            String birthday,
            boolean atWork,
            int roomNumber) {
        super(name, surname, education, birthday, atWork);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
