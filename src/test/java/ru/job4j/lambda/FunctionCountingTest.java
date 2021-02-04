package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCountingTest {

    private FunctionCounting diapason = new FunctionCounting();

    public FunctionCounting getDiapason() {
        return diapason;
    }

    public void setDiapason(FunctionCounting diapason) {
        this.diapason = diapason;
    }

    @Test
    public void whenLinearFunctionCountThenLinearResults() {

        List<Double> result = diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionCountThenSquareResults() {

        List<Double> result = diapason.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowFunctionCountThenShowResults() {

        List<Double> result = diapason.diapason(5, 8, x -> 2 * x);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result, is(expected));
    }
}