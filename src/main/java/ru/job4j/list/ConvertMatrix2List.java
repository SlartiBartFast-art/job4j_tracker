package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
   // необходимо реализовать обратную конвертацию двухмерного массива в одномерный список.
        public List<Integer> toList(int[][] array) {
            List<Integer> list = new ArrayList<>();
            for (int[] row : array) { // копируем значение из двух мерн масс в одномерный
                for (int cell : row) { // вынимаем по одной значения изапсис в обыч перемен
                        list.add(cell);
                }
            }
            return list;
        }
}
