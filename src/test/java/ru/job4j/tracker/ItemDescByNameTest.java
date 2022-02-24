package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void sortRevers() {
        List<Item> items = Arrays.asList(
                new Item("A", 3),
                new Item("D", 1),
                new Item("B", 2),
                new Item("C", 4)
        );
        List<Item> expected = Arrays.asList(
                new Item("D", 1),
                new Item("C", 4),
                new Item("B", 2),
                new Item("A", 3)
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}