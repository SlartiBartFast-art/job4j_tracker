package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<Item>();
    //private final Item[] pow = new Item[100];
    // массив для хранения заявок - возможное колличество заявлений
    private int ids = 1; //генерации уникального идентификатора для заявки(нового ключа)
    private int size = 0; //Это поле и есть размер нового массива.

    /** Суть метода, добавляет заявку, переданную в аргументах в массив заявок items
     */

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**Метод public Item [] findAll () возвращает массив
     * элементов без нулевых элементов (без пустых ячеек).
      */

        public List<Item> findAll() {
            return items;
        }

/** Алгоритм этого метода аналогичен методу findAll.
   */

    public List<Item> findByName(String key) {
        List<Item> nameKey = new ArrayList<Item>();
        for (Item element : items) {
            String nameF = element.getName();
            if (key.equals(nameF)) {
                nameKey.add(element);
            }
        }
             return nameKey;
    }

/**проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
 и возвращает найденный Item. Если Item не найден - возвращает null.
 * */

    public Item findById(int id) {
        int rsl = indexOf(id);
        return (rsl >= 0 ? items.get(rsl) : null);
    }

/**метод возвразает индекс по id
 * */

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

/** метод замены заявкиТо есть удалить заявку, которая уже есть в системе
 * и добавить в эту ячейку новую.
 * */

        public boolean replace(int id, Item item) {
            int idF = indexOf(id);
            if (idF >= 0) {
                items.set(idF, item);
                item.setId(id);
               return true;
           }
            return false;
        }

/** метод удаления заявки
 * */

    public boolean delete(int id) {
        int rsl = indexOf(id);
        if (rsl >= 0) {
            this.items.remove(rsl);
            return true;
        }
        return false;
    }
}