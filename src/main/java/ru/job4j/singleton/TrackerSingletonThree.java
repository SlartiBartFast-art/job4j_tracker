package ru.job4j.singleton;



import ru.job4j.tracker.Tracker;

public class TrackerSingletonThree { // Основное отличие, мы сразу создаем и инициализируем объект.
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingletonThree() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }



    public static void main(String[] args) {

        Tracker tracker = TrackerSingletonThree.getInstance();
    }

}

