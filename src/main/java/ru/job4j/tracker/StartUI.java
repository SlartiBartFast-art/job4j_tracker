package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) { // два объекта Scanner scanner/Input input(Отвязали, провели интерфейс) , Tracker tracker
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 - 6 " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);

        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

        public static void main(String[]args) {
            Output output = new ConsoleOutput();
            Input input = new ValidateInput();
            Tracker tracker = new Tracker();
            UserAction[] actions = {new CreateAction(output),
                                    new CreateShowAllItems(output),
                                    new CreateEditItem(output),
                                    new CreateDeleteItem(output),
                                    new CreateFindItemById(output),
                                    new CreatedFindItemByName(output),
                                    new CreateExit(output)};
            new StartUI(output).init(input, tracker, actions);

        }
    }