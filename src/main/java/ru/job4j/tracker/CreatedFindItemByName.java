package ru.job4j.tracker;

public class CreatedFindItemByName implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Please. Enter name Item which you want find: ");
        Item[] namez = tracker.findByName(name);
        if (namez.length > 0) {
            for (int i = 0; i < namez.length; i++) {
                System.out.println(namez[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
            return false;
        }
        return true;
    }
}
