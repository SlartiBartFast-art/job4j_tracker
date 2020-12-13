package ru.job4j.tracker;

public class CreateFindItemById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please. Enter id Item which you want to find: ");
        Item dez = tracker.findById(id);
        if (dez != null) {
            System.out.println(dez);
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
