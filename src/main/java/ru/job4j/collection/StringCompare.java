package ru.job4j.collection;

import java.util.Comparator;

//import static jdk.vm.ci.meta.JavaKind.Char;
//import static jdk.vm.ci.meta.JavaKind.fromPrimitiveOrVoidTypeChar;


public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) { // сравнить два слова

       /** int rsl = -1;
        char[] resX = o1.toCharArray();
        char[] resY = o2.toCharArray();
        if (resX[0] == resY[0] && resX[1] == resY[1] && resX.length == resY.length) {
            rsl = 1;
        }
        return rsl;
        }*/
       int rsl;
int x = Math.min(o1.length(), o2.length());
        for (int i = 0; i < x; i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
             if (rsl != 0) {
                 return rsl;
             }
        }
        return Integer.compare(o1.length(), o2.length());
    }
    }
