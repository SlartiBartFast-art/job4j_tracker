package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) { // два объекта Scanner scanner/Input input(Отвязали, провели интерфейс) , Tracker tracker
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Enter menu select number: "));//msg это сообщение которое мы бы хотели бы вывести пользователю перед его вводом, например "Enter id: ".
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Please. Enter name new Item: "); //2 в отдном вопрос/ответ
                Item item = new Item(name); //
                tracker.add(item);

            } else if (select == 1) {  // получение всех заявок
                Item[] item = tracker.findAll(); // записать в переменную массив? / вводим новую лок перемен
                for (Item ar: item) {
                System.out.println(ar);
                }
                /*for (int i = 0; i < item.length; i++) { //вывести массив по элементно цикл
                    System.out.println(item[i]);*/


            } else if (select == 2) { // Edit item
                int numId = Integer.valueOf(input.askStr("Enter ids Item to edit: ")); //приняли с консоли -конвертнули в int
                String name = input.askStr("Please. Enter new name item: ");
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
                int id = Integer.valueOf(input.askStr("Please. Enter id which you want to delete: "));
                boolean del = tracker.delete(id);
                if (del) {
                    System.out.println("Операция выполнена успешно.");
                    // вывод об успешности операции
                } else {
                    System.out.println("Error");
                    // вывод об ошибке
                }


            } else if (select == 4) {
                int id = Integer.valueOf(input.askStr("Please. Enter id Item which you want to find: "));  //4.1. Получить id заявки, которую мы будем искать в хранилище, через объект scanner;
                Item dez = tracker.findById(id);
                if (dez != null) {
                    System.out.println(dez);
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }

            } else if (select == 5) { // Пункт 5 - Find items by name:
                String name = input.askStr("Please. Enter name Item which you want find: ");
                Item [] namez = tracker.findByName(name); // из п1 , почему не идет?
                if (namez.length > 0) {
                    for (int i = 0; i < namez.length; i++) {
                        System.out.println(namez[i]);    // по элеменетно
                    }
                } else {
                System.out.println("Заявки с таким именем не найдены.");
            }

            } else if (select == 6) {

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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}