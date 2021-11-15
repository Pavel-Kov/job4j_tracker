package ru.job4j.tracker.inheritance;

public class Builder extends Engineer {
    private String spec;

    public Builder(
            String name,
            String surname,
            String education,
            String birthday,
            String spec,
            boolean result) {
        super(name, surname, education, birthday, result);
        this.spec = spec;
    }

    public String getSpec() {
        return spec;
    }
}
