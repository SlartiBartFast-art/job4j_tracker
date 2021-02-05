package ru.job4j.collection;

import java.util.*;

/**
 * не доделанное задание
 */
public class FreezeStr {

    /*public static boolean eq(String left, String right) {
        boolean rsl = true;
        // Map<Character, String> world = new HashMap();

        String txt = left;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(40);
        for (int i = 0; i < txt.length(); ++i) {
            char c = txt.charAt(i);
            // если надо, то проверяем является ли символ буквой
            if (Character.isLetter(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
    }

   /* public static boolean eq(String left, String right) {
        boolean rsl = true;
        Map<Character, String> world = new HashMap();
       // HashMap<String, String> wolds1 = new HashMap<>();

        String[] arr = left.split("");
        String[] arr1 = right.split("");
        System.out.println(arr);
        char[] maArr = left.toCharArray();
        for (int i = 0; i < left.length(); i++) {
            for (int j = i + 1; j < left.length(); j++) {
                if (maArr[i] == maArr[j]) {
                    maArr = ArrayUtils.remove(maArr, j);
                }
            }
        }

        for (String string : arr) {
            System.out.println(string + "\\");
            world.put(string, string);

            System.out.println(world);
        }
       // Set<String> keys = world.keySet();
        for (String string : arr1) {
            wolds1.put(string, string);
            System.out.println(wolds1);
        }

        for (Map.Entry<String, String> entry : world.entrySet()) {
            System.out.println(entry);
            if (!wolds1.containsKey(entry.getKey())) {
                //if (world)
                rsl = false;
                break;
            }
        }
        return rsl;
    }*/
}
