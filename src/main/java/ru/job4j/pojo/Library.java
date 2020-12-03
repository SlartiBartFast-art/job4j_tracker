package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("Ява для чайников", 357);
        Book two = new Book("Красная шапочка", 56);
        Book three = new Book("Космическое ракетостроение в схемах", 1578);
        Book cleanCode = new Book("Воздушные замки. Подробная инструкиция и чертежи", 357);
        Book[] array = new Book[4];
        array[0] = one;
        array[1] = two;
        array[2] = three;
        array[3] = cleanCode;
        for (int i = 0; i < args.length; i++) {
            Book bk = array[i];
            System.out.println(bk.getName() + bk.getNumberOfPage());
        }
        System.out.println("Replace Book array[0] to array[3]");

            Book rep = array[3];
            array[3] = array[0];
            array[0] = rep;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == array[3]) {
                    System.out.println("Название книги: " + cleanCode.getName() + " Колличество страниц: " + cleanCode.getNumberOfPage());
                }
            }




    }
}
