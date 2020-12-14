package ru.job4j.tracker;

public class CreateDeleteItem implements UserAction {
    public final Output out;

    public CreateDeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Please. Enter id which you want to delete: ");
        boolean bel = tracker.delete(id);
        if (bel) {
            out.println("Операция выполнена успешно.");
        } else {
            out.println("Error");
        }
        return true;
    }
}
