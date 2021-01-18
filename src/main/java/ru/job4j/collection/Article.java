package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Метод проверяет что новый текст был получен из оригинального.
 * @param
 * @param
 * @return {@code true} если строка соотвествует оригиналу
 */
public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> all = new HashSet<>();
        String orv = origin.replaceAll("\\p{P}", "");
        String[] rew = orv.split(" ");

        for (String tmp : rew) {
            all.add(tmp);
            }
        String[] lineX = line.split(" ");
        for (String tmp2 : lineX) {
            System.out.println(tmp2);
            rsl = all.contains(tmp2);
            System.out.println(rsl);
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }
}
