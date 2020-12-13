package ru.job4j.tracker;

public class CreateDeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please. Enter id which you want to delete: ");
        boolean bel = tracker.delete(id);
        if (bel) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
