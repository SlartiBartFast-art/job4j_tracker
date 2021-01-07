package ru.job4j.tracker;

import org.w3c.dom.ls.LSOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;

public class Item implements Comparable<Item> { //описывает модель заявления


    private int id; // уникальный номер заявления
    private String name; // название заявления
    private LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }
    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getCreated() {

        return created;
    }
    public void setCreated(LocalDateTime created) {

        this.created = created;
    }
    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", created=" + created + '}';
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.id);
    }

}






