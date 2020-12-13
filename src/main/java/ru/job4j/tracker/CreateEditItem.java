package ru.job4j.tracker;

public class CreateEditItem implements UserAction {
    @Override
    public String name() {
        return "=== Enter ids Item to edit: ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int numId = input.askInt("Enter ids Item to edit: ");
        String name = input.askStr("Please. Enter new name item: ");
        Item item = new Item();
        item.setName(name);
        boolean bol = tracker.replace(numId, item);
        if (bol) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
