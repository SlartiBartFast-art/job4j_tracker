package ru.job4j.tracker;

public class StartUITest {

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