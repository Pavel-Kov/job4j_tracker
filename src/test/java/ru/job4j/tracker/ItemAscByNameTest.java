package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void sort() {
        List<Item> items = Arrays.asList(
                new Item("A", 3),
                new Item("D", 1),
                new Item("B", 2),
                new Item("C", 4)
        );
        List<Item> expected = Arrays.asList(
                new Item("A", 3),
                new Item("B", 2),
                new Item("C", 4),
                new Item("D", 1)
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(items, expected);
    }
}