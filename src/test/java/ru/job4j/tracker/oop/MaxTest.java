package ru.job4j.tracker.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void maxFromTwo() {
        int one = 4;
        int two = 2;
        Max max = new Max();
        int result = max.max(one, two);
        int expected = 4;
        Assert.assertEquals(expected, result);

    }

    @Test
    public void maxFromThree() {
        int one = 4;
        int two = 2;
        int three = 7;
        Max max = new Max();
        int result = max.max(one, two, three);
        int expected = 7;
        Assert.assertEquals(expected, result);

    }

    @Test
    public void maxFromFour() {
        int one = 4;
        int two = 2;
        int three = 7;
        int four = 1;
        Max max = new Max();
        int result = max.max(one, two, three, four);
        int expected = 7;
        Assert.assertEquals(expected, result);

    }
}