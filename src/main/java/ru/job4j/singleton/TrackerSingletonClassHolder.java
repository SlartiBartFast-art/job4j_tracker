package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingletonClassHolder { // объект класса находиться в поле внутреннего класса.

    private TrackerSingletonClassHolder() {

    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingletonClassHolder.getInstance();
    }
}
