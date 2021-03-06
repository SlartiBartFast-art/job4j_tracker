package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {

/**ошибка в рабоче методе при использовании аннтоции
 * */

   /** @Test(expected = IllegalArgumentException.class)
    public void when5toErr() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is("метод вызывается с объекта в не корректном состоянии"));
    }

    /**ошибка не правильный аргумет от пользователя
     * */

    @Test(expected = IllegalArgumentException.class)
    public  void when1to0() {
        int rsl = Fact.calc(-1);
        assertThat(rsl, is("метод вызывается с объекта в не корректном состоянии"));

    }

    @Test // рабочий метод
    public void when5to120() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is(120));
    }
}