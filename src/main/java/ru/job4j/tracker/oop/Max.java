package ru.job4j.tracker.oop;

public class Max {
    public int max(int one, int two) {
        return one >= two ? one : two;
    }

    public int max(int one, int two, int three) {
        return three >= max(one, two) ? three : max(one, two);
    }

    public int max(int one, int two, int three, int four) {
        return four >= max(one, two, three) ? four : max(one, two, three);
    }
}
