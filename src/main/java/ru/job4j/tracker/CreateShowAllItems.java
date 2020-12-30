package ru.job4j.tracker;

import java.util.ArrayList;

public class CreateShowAllItems implements UserAction {
    public final Output out;

    public CreateShowAllItems(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Show all items===");
        ArrayList<Item> item  = tracker.findAll();
       // Item[] item = tracker.findAll();
        for (Item ar: item) {
            out.println(ar);
        }
        return true;
    }
}
