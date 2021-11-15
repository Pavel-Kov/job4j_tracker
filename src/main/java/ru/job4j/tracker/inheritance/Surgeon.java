package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private String hospDepart;

    public Surgeon(
            String name,
            String surname,
            String education,
            String birthday,
            boolean atWork,
            String hospDepart) {
        super(name, surname, education, birthday, atWork);
        this.hospDepart = hospDepart;
    }

    public String getHospDepart() {
        return hospDepart;
    }
}
