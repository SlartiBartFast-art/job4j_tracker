package ru.job4j.tracker;

import java.util.Scanner;
public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter items name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllitems(Input input, Tracker tracker) {
        Item[] item = tracker.findAll();
        for (Item ar: item) {
            System.out.println(ar);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        int numId = Integer.valueOf(input.askStr("Enter ids Item to edit: "));
        String name = input.askStr("Please. Enter new name item: ");
        Item item = new Item();
        item.setName(name);
        boolean bol = tracker.replace(numId, item);
        if (bol) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Please. Enter id which you want to delete: "));
        boolean del = tracker.delete(id);
        if (del) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.out.println("Error");
        }
    }
    public static void findItemById(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Please. Enter id Item which you want to find: "));
        Item dez = tracker.findById(id);
        if (dez != null) {
            System.out.println(dez);
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        String name = input.askStr("Please. Enter name Item which you want find: ");
        Item[] namez = tracker.findByName(name);
        if (namez.length > 0) {
            for (int i = 0; i < namez.length; i++) {
                System.out.println(namez[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
    }


    public void init(Input input, Tracker tracker) { // два объекта Scanner scanner/Input input(Отвязали, провели интерфейс) , Tracker tracker
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(input.askStr("Enter menu select number: "));
            /*this.showMenu(actions);
            int select = input.askInt("Select: ");
            //int select = Integer.valueOf(input.askStr("Enter menu select number: ")); //msg это сообщение которое мы бы хотели бы вывести пользователю перед его вводом, например "Enter id: ".
            UserAction action = actions[select];
            run = action.execute(input, tracker);*/
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllitems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
        }
    }
}
    private void showMenu() { /*(UserAction[] actions) {
        System.out.println("Menu.");
        /*for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }*/
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
       /* UserAction[] actions = {new CreateAction()};*/
        /*new StartUI().init(input, tracker, actions);*/

    }
}