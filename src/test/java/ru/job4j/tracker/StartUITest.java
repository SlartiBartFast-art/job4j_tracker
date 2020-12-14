package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new CreateExit()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = "1";
        //int id = item.getId();
         String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", "1", "New item name", "1"}); /* входные параметры для ReplaceAction */
        UserAction[] actions = {new CreateEditItem(), new CreateExit()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        String id = "1";
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions = {new CreateDeleteItem(), new CreateExit()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
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
}