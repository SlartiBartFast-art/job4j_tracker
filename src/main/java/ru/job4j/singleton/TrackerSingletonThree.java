package ru.job4j.singleton;


import ru.job4j.tracker.Item;

public class TrackerSingletonThree { // Основное отличие, мы сразу создаем и инициализируем объект.
    private static final TrackerSingletonThree INSTANCE = new TrackerSingletonThree();

    private TrackerSingletonThree() {
    }

    public static TrackerSingletonThree getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingletonThree tracker = TrackerSingletonThree.getInstance();
    }

}

