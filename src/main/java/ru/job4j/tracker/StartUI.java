package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) { // два объекта Scanner scanner, Tracker tracker
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name); //
                tracker.add(item);

            } else if (select == 1) {  // получение всех заявок
                Item[] item = tracker.findAll(); // записать в переменную массив? / вводим новую лок перемен
                    for (int i = 0; i < item.length; i++) { //вывести массив по элементно цикл
                    System.out.println(item[i]);
                }

            } else if (select == 2) { // Edit item

                int numId = Integer.valueOf(scanner.nextLine()); //приняли с консоли -конвертнули в int
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                boolean bol = tracker.replace(numId,item);
                if (bol) {
                    System.out.println("Операция выполнена успешно.");
                    // вывод об успешности операции
                } else {
                    System.out.println("Error");
                    // вывод об ошибке
                }
            } else if (select == 3) { // delete item

                int id = Integer.valueOf(scanner.nextLine());

                boolean del = tracker.delete(id);

                if (del) {
                    System.out.println("Операция выполнена успешно.");
                    // вывод об успешности операции
                } else {
                    System.out.println("Error");
                    // вывод об ошибке
                }


            } else if (select == 4) {
                int id = Integer.valueOf(scanner.nextLine());       //4.1. Получить id заявки, которую мы будем искать в хранилище, через объект scanner;
                Item dez = tracker.findById(id);
                if (dez != null) {
                    System.out.println(dez);
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }

            } else if (select == 5) { // Пункт 5 - Find items by name:
                String name = scanner.nextLine();
                Item [] namez = tracker.findByName(name); // из п1 , почему не идет?
                if (namez.length > 0) {
                    for (int i = 0; i < namez.length; i++) {
                        System.out.println(namez[i]);    // по элеменетно
                    }
                } else {
                System.out.println("Заявки с таким именем не найдены.");
            }

            } else if (select == 6) {
            int num = Integer.valueOf(scanner.nextLine());
            run = false;
            }
        }
    }
}
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
        /* добавить остальные пункты меню. */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}