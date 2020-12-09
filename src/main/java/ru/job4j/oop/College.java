package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman petya = new Freshman(); // создаем объект
        Student vasya = petya; //
        Object okno = petya; /* делаем приведение к типу родителя Object. */
        Object okar = new Freshman();
    }

}
