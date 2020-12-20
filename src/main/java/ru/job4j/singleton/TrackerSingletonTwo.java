package ru.job4j.singleton;

import ru.job4j.tracker.Item;
/**Для того чтобы закрыть возможность создавать экземпляр класса,
        нам нужно явно создать конструктор по умолчанию и присвоить ему модификатор private.
 * */

public class TrackerSingletonTwo {
    private static TrackerSingletonTwo instance;

    private TrackerSingletonTwo() {
    }

    public static TrackerSingletonTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingletonTwo();
        }

        return instance;
    }
    public Item add(Item model) {
        return model;
    }
}
