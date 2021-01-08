package ru.job4j.ex;
/**Допишите метод поиска индекса элемента в строковом массиве.
 * */
public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
            for (String word: value) {
                rsl += 1;
                if (word.equals(key)) {
                    return rsl;
                }
            }
                throw new ElementNotFoundException("такого элемента нет");
    }

    public static void main(String[] args) {
        String[] array = new String[]{"Fedr", "Ivan", "Petr", "Nikolai", "Fedor"};
        try {
            indexOf(array, "Vasya");
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

