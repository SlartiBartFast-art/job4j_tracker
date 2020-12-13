package ru.job4j.tracker;

public class CreateShowAllItems implements UserAction {
    @Override
    public String name() {
        return "===Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] item = tracker.findAll();
        for (Item ar: item) {
            System.out.println(ar);
        }
        return true;
    }
}
