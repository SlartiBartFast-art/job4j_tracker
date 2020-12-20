package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingletonClassHolder { // объект класса находиться в поле внутреннего класса.

    private TrackerSingletonClassHolder() {

    }
    public static TrackerSingletonClassHolder getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingletonClassHolder INSTANCE = new TrackerSingletonClassHolder();
    }

    public static void main(String[] args) {
        TrackerSingletonClassHolder tracker = TrackerSingletonClassHolder.getInstance();
    }
}
