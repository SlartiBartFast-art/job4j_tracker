package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class ItemTest {


    @Test
    public void compareToId() {
        List<Item> items = Arrays.asList(new  Item(7, "Fix bugs"), new Item(9, "Impl task"), new Item(3, "Reboot server"));
        Collections.sort(items);
    assertThat(items.get(0).getId(), is(3));


    }
   @Test
    public void compareToD() {
        List<Item> items = Arrays.asList(new  Item(1, "Fix bugs"), new Item(3, "Impl task"), new Item(4, "Reboot server"));

   Collections.sort(items, Collections.reverseOrder());
   assertThat(items.get(0).getName(), is("Reboot server"));
   //tracker.add()

    }
}