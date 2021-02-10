package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    public List<Integer> pow;

   private EasyStream(List<Integer> integers) {
        pow = integers;
    }
    private EasyStream() {
        }



    /**
     * получает исходные данные.
     */
    public static EasyStream of(List<Integer> source) {
        List<Integer> rsl = new ArrayList<>();
        rsl.addAll(source);
        return new EasyStream(rsl);
    }

    /**
     * преобразует число в другое число.
     */
    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> sow = new ArrayList<>();
        for (Integer integer : pow) {
            Integer count = fun.apply(integer);
            sow.add(count);
        }
        return new EasyStream(sow);
    }

    /**
     * фильтрует поток элементов.
     */

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> wer = new ArrayList<>();
        for (Integer intel : pow) {
            if (fun.test(intel)) {
                wer.add(intel);
            }
        }
        return new EasyStream(wer);
    }

    /**
     * собирает все элементы из источника по заданным условиям map и filter.
     */
    public List<Integer> collect() {
        
        return pow;
    }

}