package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] itemsNotNull = new Item[items.length];
        int sizeTmp = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemsNotNull[i] = items[i];
                sizeTmp++;
            }
        }
        return Arrays.copyOf(itemsNotNull, sizeTmp);
    }

    public Item[] findByName(String key) {
        Item[] itemsNotNull = new Item[items.length];
        int sizeTmp = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                itemsNotNull[i] = items[i];
                sizeTmp++;
            }
        }
        return Arrays.copyOf(itemsNotNull, sizeTmp);
    }

    public Item[] replace(int id, Item item) {
        int index = indexOf(id);
        int idSave = items[index].getId();
        items[index] = item;
        items[index].setId(idSave);
        return items;
    }

    public Item[] delete(int id) {
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[size - 1] = null;
        size--;
        return items;
    }
}