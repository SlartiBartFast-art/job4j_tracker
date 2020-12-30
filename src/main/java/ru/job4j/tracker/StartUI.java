package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) { // два объекта Scanner scanner/Input input(Отвязали, провели интерфейс) , Tracker tracker
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 - " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            //UserAction action = actions[select];
            run = action.execute(input, tracker);

        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int index = 0;
        for (UserAction action :actions) {

            out.println(index + ". " + action.name());
            index++;
        } //for (int index = 0; index < actions.length; index++)
    }


        public static void main(String[]args) {
            Output output = new ConsoleOutput();
            Input input = new ValidateInput(output, new ConsoleInput());
            Tracker tracker = new Tracker();
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new CreateShowAllItems(output));
            actions.add(new CreateEditItem(output));
            actions.add(new CreateDeleteItem(output));
            actions.add(new CreatedFindItemByName(output));
            actions.add(new CreatedFindItemByName(output));
            actions.add(new CreateExit(output));
            new StartUI(output).init(input, tracker, actions);
        /**UserAction[] actions = {new CreateAction(output),
                                    new CreateShowAllItems(output),
                                    new CreateEditItem(output),
                                    new CreateDeleteItem(output),
                                    new CreateFindItemById(output),
                                    new CreatedFindItemByName(output),
                                    new CreateExit(output)};
            new StartUI(output).init(input, tracker, actions);*/

        }
    }