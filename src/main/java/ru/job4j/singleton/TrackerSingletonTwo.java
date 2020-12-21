package ru.job4j.singleton;


import ru.job4j.tracker.Tracker;

/**Для того чтобы закрыть возможность создавать экземпляр класса,
        нам нужно явно создать конструктор по умолчанию и присвоить ему модификатор private.
 * */

public class TrackerSingletonTwo {
    private static Tracker instance;

    private TrackerSingletonTwo() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }

        return instance;
    }

}
