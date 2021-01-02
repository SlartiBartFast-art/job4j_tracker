package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<Item>(100);
    //private final Item[] pow = new Item[100]; // массив для хранения заявок - возможное колличество заявлений
    private int ids = 1; // это поле для генерации уникального идентификатора для заявки(нового ключа)
    private int size = 0; // У нас есть поле size. Это поле и есть размер нового массива.



    /** каждый вызов метод add будет добавлять в поле ids единицу.
     Так мы сможем обеспечить уникальность поле id в Item.
     //Суть метода, добавляет заявку, переданную в аргументах в массив заявок items
     */
    public Item add(Item item) { // pow -items /cell -item
        item.setId(ids++);
        items.add(item); // вставка в коллекцию
        //pow[size++] = item;
        return item;
    }

    /**Чтобы получить новый массив, нужно использовать метод Arrays.copyOf.
     * возвращает копию массива items без null элементов (без пустых ячеек).
     * Метод public Item [] findAll () возвращает массив элементов без нулевых элементов (без пустых ячеек).
      */

        public List<Item> findAll() {
            return items;
        }


/**проверяет в цикле все элементы массива items, сравнивая name (используя метод
 *  getName класса Item) с аргументом метода String key. Элементы, у которых
 *  совпадает name, копирует в результирующий массив и возвращает его.
 *  Алгоритм этого метода аналогичен методу findAll.
   */
    public List<Item> findByName(String key) { //public Item[] findByName(String key) { // создание списка по имени в новый массив

        List<Item> nameKey = new ArrayList<Item>();
        for (Item element : items) {
            String nameF = element.getName(); //получили Str name
            if (key.equals(nameF)) {
                nameKey.add(element);
            }
        }
             return nameKey;
    }


        //Item[] nameKey = new Item[pow.length];
        //int size = 0;
        //for (int i = 0; i < this.size; i++) { // было int i = 0;  i < items.length; i++;- тоже самое только длина массива
            //if (key.equals(pow[i].getName())) { // сравнение метод эквалс
              //  nameKey[size] = pow[i];
               // size++;

                //}
            //}
        //nameKey = Arrays.copyOf(nameKey, size);

        //return nameKey;
    //}
/**проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
 и возвращает найденный Item. Если Item не найден - возвращает null.
 * */

    public Item findById(int id) { // получение заявки по id

        int rsl = indexOf(id);
        return (rsl >= 0 ? items.get(rsl) : null);
    }




        /**rsl = items.indexOf(id); // нашли индекс заявки
         if (rsl >= 0) { // проверка что такая заявка существует
         rsl1 = items.get(rsl); // нашли элемент
        for (Item element : items) {
            int idF = element.getId();
            if (idF == id) {
                rsl = element;
                //return rsl;
            }
        }
        return rsl;*/


        //Item rsl = null;
        //for (int index = 0; index < size; index++) {
           // Item item = pow[index];
           // if (item.getId() == id) {
               // rsl = item;
               // break;
            //}
       // }
       // return rsl;
   // }
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
    /** for (Item element : items) {
        int idF = element.getId();
            for (int i = 0; i < items.size() - 1; i++) {

            }
            if (idF == id) {
                rsl = items.indexOf(element);
            }
        } return rsl;*/

//}
    /**private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (pow[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }*/
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
    /**public boolean replace(int id, Item item) {
        int index = indexOf(id); // находим индекс ячейки по id
        if (index >= 0) { // проверка что индекс полож число, т.к. метод indexOf может вернуть -1

            item.setId(id); // проставляем новый id из параметров
            pow[index] = item; // записать в ячеку с найденным индексом объект item
            return true; // вурнуть тру если замена произведена
        }
        return false; // вернть фалсу если index по id не найден
    }*/

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
       /** for (Item element : items) {
            int idF = element.getId();
            if (idF == id) {
                items.remove(element);
                return true;
            }
        }
        return false;
    }
        /**int startPos = indexOf(id); // вращаем индекс заявки которую надо рубануть
        if (startPos == -1) {
        return  false;
        }
        int distPos = startPos + 1;
        int length = size - startPos;
        System.arraycopy(pow, startPos + 1, pow, distPos, length); // перекопируем все в новый результ массив с темже именем
        pow[size - 1] = null;
        size--;
        return true;

    }*/


}