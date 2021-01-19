package ru.job4j.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/** не доделанное задание
 * */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        List<String> world = new LinkedList<>();
        String[] arr = left.split("");
        String[] arr1 = right.split("");
        System.out.println(arr1);

        for (String string : arr1) {
            System.out.println(string + "\\");
            world.add(string);
            System.out.println(world);
        }


        for (String string : arr) {
            System.out.println(string);
            if (!world.contains(string)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
