package ru.job4j.oi;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        //boolean run = true;
        System.out.println("Игра. На столе лежат 11 спичек."); // Когда игрок ввел цифру, нужно показать сколько спичек осталось на столе.
        System.out.println("Два игрока по очереди берут от 1 до 3 спичек.");
        System.out.println("Выигрывает тот, кто забрал последние спички.");
        System.out.println("Спичек на столе осталось: " + 11);

        int bilo = 11;
        while (bilo > 0) { // в цикле нужно проверять колличество спичек
            System.out.println("Игрок №1 Ваш ход:");
            int select1 = Integer.valueOf(input1.nextLine());
            bilo -= select1;
            System.out.println("Спичек на столе осталось: " + bilo);
            System.out.println("Игрок №2 Ваш ход:");
            int select2 = Integer.valueOf(input2.nextLine());
            bilo -= select2;
            System.out.println("Спичек на столе осталось: " + bilo);





            }
        System.out.println("Игра окончена");
    }
}

