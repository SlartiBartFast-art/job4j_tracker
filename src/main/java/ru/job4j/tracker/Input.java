package ru.job4j.tracker;

public interface Input { // источник данных
    String askStr(String question);

    int askInt(String question);

}
