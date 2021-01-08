package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/** бывший класс StartUI в задании 6 блок ООП
 * не правильно указан класс на StartUI
 * */

public class UsagePackageDate {
    public static void main(String[] args) {
        Item current = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String message = formatter.format(current.getCreated());
        System.out.println("Текущие дата и время после форматирования: " + message);
        Item text = new Item();
        System.out.println(text);
        Tracker tracker = new Tracker();
        tracker.add(current);

        System.out.println(tracker.findById(1));
    }
}
