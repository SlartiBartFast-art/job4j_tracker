package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra Tra Tra");
    }
    public void song() {
        System.out.println("I Believe i can fly");
    }
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
