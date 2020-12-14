package ru.job4j.tracker;

public class CreateExit implements UserAction {
    private final Output out;

    public CreateExit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit program ===");

        return false;
    }
}