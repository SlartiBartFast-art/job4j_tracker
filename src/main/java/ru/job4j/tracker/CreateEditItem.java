package ru.job4j.tracker;

public class CreateEditItem implements UserAction {
    private final Output out;

    public CreateEditItem(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Enter ids Item to edit: ===");
        int numId = input.askInt("Enter ids Item to edit: ");
        String name = input.askStr("Please. Enter new name item: ");
        Item item = new Item();
        item.setName(name);
        boolean bol = tracker.replace(numId, item);
        if (bol) {
            out.println("Операция выполнена успешно.");
        } else {
            out.println("Error");
        }
        return true;
    }
}
