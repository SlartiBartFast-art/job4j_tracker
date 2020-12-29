package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
   //Метод convert должен пройтись по всем элементам всех массивов в списке list и добавить их в список rsl.
        public static List<Integer> convert(List<int[]> list) {
            List<Integer> rsl = new ArrayList<>();
            for (int[] row : list) {
                for (int sell : row) {
                    rsl.add(sell);
                }
            }
            /// for-each
            return rsl;
        }
    }

