package ru.job4j.tracker.inheritance;

public class Doctor extends Profession {
    private boolean atWork;

    public Doctor(
            String name,
            String surname,
            String education,
            String birthday,
            boolean atWork) {
        super(name, surname, education, birthday);
        this.atWork = atWork;
    }

    public boolean getAtWork() {
        return atWork;
    }

}
