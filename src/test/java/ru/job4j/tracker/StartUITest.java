package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {new CreateAction(output), new CreateExit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = "1";
        //int id = item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", "1", "New item name", "1"}); /* входные параметры для ReplaceAction */
        UserAction[] actions = {new CreateEditItem(output),
                new CreateExit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        String id = "1";
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(new String[]{"0", "1", "1"});
        UserAction[] actions = {new CreateDeleteItem(output), new CreateExit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    } /* верхние три теста после заглушки Output*/

    @Test
    public void whenExit() { //косячный
        Output out = new StubOutput(); //создается объект класса Output
        Input in = new StubInput(new String[]{"0"}); //создается объект класса Input
        Tracker tracker = new Tracker(); // Создается объект класса Tracker
        UserAction[] actions = {new CreateExit(out)}; // создается массив команд, которые будут передаваться
        // в метод и имитировать ввод команды
        new StartUI(out).init(in, tracker, actions); // в конструктор StartUI передается out, запускается метод init, в который передаются параметры in, tracker
        // и actions
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator() + "=== Exit program ===" + System.lineSeparator())); // проверка соответствия
        // того, что выведено на экран образцу
    }

    @Test
    public void findAllAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show"));
        Input in = new StubInput(new String[] {"0", "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new CreateShowAllItems(out), new CreateExit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Show" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator() + "===Show all items===" + System.lineSeparator()
                + item + System.lineSeparator() + "Menu." + System.lineSeparator() + "0. Show" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator() + "=== Exit program ===" + System.lineSeparator()));

    }

    @Test
    public void findByNameAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("some name"));
        Input in = new StubInput(new String[] {"0", "some name", "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new CreatedFindItemByName(out), new CreateExit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Find name"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Find item by name ==="
                + System.lineSeparator() + item + System.lineSeparator() + "Menu." + System.lineSeparator() + "0. Find name"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Exit program ===" + System.lineSeparator()));
    }

    @Test
    public void findByIdAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name"));
        Input in = new StubInput(new String[] {"0", "1", "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new CreateFindItemById(out), new CreateExit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Find id"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ===" + System.lineSeparator() + item
                + System.lineSeparator() + "Menu." + System.lineSeparator()
                + "0. Find id" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Exit program ===" + System.lineSeparator()));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput(); // вывод в консоль мы заменяем Интерфейсом OutPut/ 2 реализации StubOutput - заглушка, Console Output консольный вывод
        Input in = new StubInput(new String[] {"7", "0"}); /* Пункты меню: неверный, верный.*/
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateExit(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 - 0%n"
                                + "Menu.%n"
                                + "0. Exit%n")));
    }
}




    /*@Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker(); //Создаем объект tracker.
        Item item = new Item("new item"); //Создаем объект item.
        tracker.add(item); // добаляем item в tracker. После этой операции у нас есть id."replaced item"/* id сохраненной заявки в объект tracker.
        String[] answers = {String.valueOf(item.getId()), "replaced item"}; //  Достаем item.id и создаем массив с ответами пользователя.
        StartUI.editItem(new StubInput(answers), tracker); //Вызываем тестируемый метод replaceItem. Это действие изменит состояние объекта tracker.
        Item replaced = tracker.findById(item.getId()); //Ищем по item.id замененный item в объекте tracker.
        assertThat(replaced.getName(), is("replaced item")); //Сравниваем имя найденной заявки с ожидаемой.
    }
    @Test //Напишите тест на метод StartUI.deleteItem. В этом случае поиск в объекте tracker должен вернуть null.
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId())}; // Достаем item.id и создаем массив с ответами пользователя
        StartUI.deleteItem(new StubInput(answer), tracker); // //Вызываем тестируемый метод deleteItem. Это действие изменит состояние объекта tracker
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue())); // сравниеваем действительность/ожидание
    }*/
