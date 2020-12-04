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

    public Item[] findAll(Item[] items) {
        Item[] namesWithsoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item pow = items[i];
            if (pow != null) {
                namesWithsoutNull[size] = pow;
                size++;
                namesWithsoutNull = Arrays.copyOf(namesWithsoutNull, size);
                for (int j = 0; j < namesWithsoutNull.length; j++) {
                    System.out.println(namesWithsoutNull[j]);
                }
            }
        }
        return namesWithsoutNull;
    }

    public Item[] findByName(String key) {
        Item[] nameKey = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (key.equals(items[i].getName())) {
                nameKey[size] = items[i];
                size++;
                nameKey = Arrays.copyOf(nameKey, size);
                for (int j = 0; j < nameKey.length; j++) {
                    System.out.println(nameKey[j]);
                }
            }

        }
        return nameKey;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}