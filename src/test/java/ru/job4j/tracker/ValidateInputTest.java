package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() { // пример
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1)); // было 1
    }

    @Test
    public void whenInvalidInputOk() { // правильный ввод, многократный правильный ввод, ввод отрицательного числа,
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
    @Test
    public void whenInvalidInputoMeny() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1)); // было 1
        }

    @Test
    public void whenInvalidInputMinus() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1)); // было 1
        }
}