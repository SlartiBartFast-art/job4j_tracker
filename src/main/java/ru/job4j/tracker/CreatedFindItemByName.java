package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class CreatedFindItemByName implements UserAction {
    private final Output out;

    public CreatedFindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Please. Enter name Item which you want find: ");
        List<Item> namez = tracker.findByName(name);
        if (namez.size() > 0) {
            for (int i = 0; i < namez.size(); i++) {
                out.println(namez.get(i));
            }
        } else  {
                out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }

}

        /**Item[] namez = tracker.findByName(name);
        if (namez.length > 0) {
            for (int i = 0; i < namez.length; i++) {
                out.println(namez[i]);
            }
        } else {
            out.println("Заявки с таким именем не найдены.");

        }
        return true;
    }*/

