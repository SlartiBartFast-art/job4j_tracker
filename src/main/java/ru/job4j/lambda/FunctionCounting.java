package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionCounting {
    // FunctionRsl<Double, Double> func = new FunctionRsl();
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();

        for (double i = start; i < end; i++) {

            rsl.add(func.apply(i));
            System.out.println(rsl);
        }
    return rsl;
    }

}
