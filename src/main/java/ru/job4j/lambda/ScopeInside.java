package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int finalTotal = total + num;

            total = add(
                    () ->  finalTotal);

        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        System.out.println(calc.get() + "/0000");
        return calc.get();

    }
}
