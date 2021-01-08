package ru.job4j.tracker;

public class CreateFindItemById implements UserAction {
    private final Output out;

    public CreateFindItemById(Output out) {
        this.out = out;
    }

    public Output getOut() {
        return out;
    }

    @Override
    public String name() {
        return "Find id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ===");
        int id = input.askInt("Please. Enter id Item which you want to find: ");
        Item dez = tracker.findById(id);
        if (dez != null) {
            out.println(dez);
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
