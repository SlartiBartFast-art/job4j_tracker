package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    /**
     * Метод может сортировать элементы по номеру. сравнивает целиком номер
     * @param left текстовы строка с перечнем
     * @param right текстовая сторока с перечнем
     * @return
     * */
    @Override
    public int compare(String left, String right) {
       String[] leF = left.split("\\.");
       String[] rF = right.split("\\.");
       String d = leF[0];
       String b = rF[0];
      return Integer.compare(Integer.parseInt(d.trim()), Integer.parseInt(b.trim()));
    }
}
