package ru.job4j.inheritance;

public class Engineer extends Profession {
    private boolean result;

    public Engineer(
            String name,
            String surname,
            String education,
            String birthday,
            boolean result) {
        super(name, surname, education, birthday);
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

}
