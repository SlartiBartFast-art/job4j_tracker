package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingletonEnum {
INSTANCE;

    private TrackerSingletonEnum() {

    }

    public Item sdd(Item model) {
        return model;
    }
}
