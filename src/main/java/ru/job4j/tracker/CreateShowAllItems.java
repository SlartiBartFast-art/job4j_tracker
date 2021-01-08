package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class CreateShowAllItems implements UserAction {
    private final Output out;

    public CreateShowAllItems(Output out) {
        this.out = out;
    }

    public Output getOut() {
        return out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Show all items===");
        List<Item> item  = tracker.findAll();
       // Item[] item = tracker.findAll();
        for (Item ar: item) {
            out.println(ar);
        }
        return true;
    }
}
