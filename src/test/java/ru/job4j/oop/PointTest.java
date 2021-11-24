package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        assertEquals(2, a.distance(b), 2);
    }

    @Test
    public void distance3d() {
        Point a3d = new Point(0, 0, 2);
        Point b3d = new Point(1, 0, 2);
        assertEquals(1, a3d.distance3d(b3d), 2);
    }
}