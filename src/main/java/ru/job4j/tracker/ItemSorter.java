package ru.job4j.tracker;
import java.util.Comparator;

public class ItemSorter implements Comparator<Item> {
    @Override
    public int compare(Item itemF, Item itemS) {
        return itemF.getName().compareTo(itemS.getName());
    }
}
