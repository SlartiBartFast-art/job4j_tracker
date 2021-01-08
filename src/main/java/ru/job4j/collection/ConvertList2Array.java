package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) { //числонакотороеделим список
        int groups = (int) Math.ceil((double) list.size() / cells); //числочерезметодmath.ceilвинт
        int[][] array = new int[groups][cells]; //создаем массив с кол-м элеме-в селлс
        int row = 0, cell = 0; // инициир 2 числа
        for (Integer num : list) {
            array[row][cell] = num; //новый 2-х мермассив вячейкупоиндексам тек значе нум
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
                }
            }
            return array; // вернули результат
        }

        public static void main(String[] args) {
            List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
            int[][] rsl = toArray(list, 3);
            for (int[] row : rsl) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
}
