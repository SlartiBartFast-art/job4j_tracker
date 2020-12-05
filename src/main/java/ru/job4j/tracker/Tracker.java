package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100]; // массив заявок - возможное колличество заявлений
    private int ids = 1; // это поле для генерации уникального идентификатора для заявки(нового ключа)
    private int size = 0; // У нас есть поле size. Это поле и есть размер нового массива.


    /** каждый вызов метод add будет добавлять в поле ids единицу.
     Так мы сможем обеспечить уникальность поле id в Item.
     //Суть метода, добавляет заявку, переданную в аргументах в массив заявок items
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**Чтобы получить новый массив, нужно использовать метод Arrays.copyOf.
     * Метод public Item [] findAll () возвращает массив элементов без нулевых элементов (без пустых ячеек).
      */

    public Item[] findAll(Item[] items) { // получение списка всех заявок

        return Arrays.copyOf(items, size);
    }
/**проверяет в цикле все элементы массива items, сравнивая name (используя метод
 *  getName класса Item) с аргументом метода String key. Элементы, у которых
 *  совпадает name, копирует в результирующий массив и возвращает его.
 *  Алгоритм этого метода аналогичен методу findAll.
   */
    public Item[] findByName(String key) { // создание списка по имени в новый массив
        Item[] nameKey = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (key.equals(items[i].getName())) { // сравнение метод эквалс
                nameKey[size] = items[i];
                size++;

                }
            }
        nameKey = Arrays.copyOf(nameKey, size);
            for (int j = 0; j < nameKey.length; j++) {
                System.out.println(nameKey[j]);

        }
        return nameKey;
    }
/**проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
 и возвращает найденный Item. Если Item не найден - возвращает null.
 * */
    public Item findById(int id) { // получение заявки по id
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
/**метод возвразает индекс по id
 * */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id); // находим индекс ячейки по id
        if (index >= 0) { // проверка что индекс полож число, т.к. метод indexOf может вернуть -1
            int tmp = item.getId(); // сохраняем старый id
            item.setId(id); // проставляем новый id из параметров
            items[index] = item; // записать в ячеку с найденным индексом объект item
            return true; // вурнуть тру если замена произведена
        }
        return false; // вернть фалсу если index по id не найден
    }

}