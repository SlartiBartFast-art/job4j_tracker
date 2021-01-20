package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
       String[] atts = {
                ("image 1"),
                ("image 32"),
                ("image 125")};

        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
           return Integer.compare(right.length(), left.length());
        };

    Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));

        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compareTo - " + left + " : " + right);
        return left.compareTo(right);
        };
        Arrays.sort(atts, cmpText);
        System.out.println(Arrays.toString(atts));

        String[] names = {
                "Ivan",
                "Petr"
        };
/* если ничего нет для сортировки/не сработала. принта не выйдет*/
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
