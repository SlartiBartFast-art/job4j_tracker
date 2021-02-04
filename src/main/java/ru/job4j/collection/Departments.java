package ru.job4j.collection;

import java.util.*;
import java.util.Collections;

public class Departments {

    /**
     * Метод осуществляет добавление пропущенных подразделения,
     * а также осуществляет сортировку имеющихся подразделений.
     *
     * @param deps коллекция String существующих подразделений.
     * @return
     */

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>(); // HashSet не хранит дубликате-нет возможности изменять элементы в списке
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    start = el;
                    tmp.add(el);
                } else {
                    tmp.add(start + "/" + el);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * метод сортирует по возрастанию
     */
    public static void sortAsc(List<String> deps) {
        deps.sort(Comparator.naturalOrder());
    }

    /**
     * Для сортировки по убыванию реализуйте отдельный компаратор.
     */

    public static void sortDesc(List<String> orgs) {

        Collections.sort(orgs, new DepDescComp());
    }
}