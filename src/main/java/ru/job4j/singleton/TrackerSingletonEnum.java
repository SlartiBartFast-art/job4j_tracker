package ru.job4j.singleton;


import ru.job4j.tracker.Tracker;

public enum TrackerSingletonEnum {
INSTANCE;
    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }


}
