package ru.job4j.oi;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = new String[2];
        System.out.println("Введите имя игрока 1");
        array[0] = scanner.nextLine();
        System.out.println("ВВедите имя игрока 2");
        array[1] = scanner.nextLine();
        int bilo = 11;
        int player = 0;
        while (bilo > 0) {
            player = player % 2;
           // player = player == 0 ? 1 : 0;
            System.out.println("Введите число игрок: " + array[player]);


            int select = Integer.valueOf(scanner.nextLine()); // преобразование строки в инт
            if (select < 4 && select > 0) {
                bilo -= select;

                System.out.println("Спичек на столе осталось: " + bilo);



            } else {
                System.out.println("Спичек можно брать не больше 3 шт. Пожалуйста попробуйте снова");
            }
            player++;
        }
        System.out.println("Game over. Win: " + array[player - 1 ]);


    }
}
