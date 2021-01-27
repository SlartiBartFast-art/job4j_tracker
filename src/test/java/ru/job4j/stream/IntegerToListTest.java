package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class IntegerToListTest {
   int[][] duosArr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};


    @Test
    public void sorteToInt() {
        IntegerToList listT = new IntegerToList();

        List<Integer> rsl = listT.sorteToInt(duosArr);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        expect.add(7);
        expect.add(8);
        expect.add(9);
        expect.add(10);
        expect.add(11);
        expect.add(12);
        assertThat(rsl, is(expect));
    }
}