package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

public class IntegerToList {

    //int[][] duosArr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    public static List<Integer> sorteToInt(int[][] duosArr) {
        return Stream.of(duosArr)
                .flatMapToInt(Arrays::stream)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
