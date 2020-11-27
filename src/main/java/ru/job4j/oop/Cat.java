package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("Cat name: " + this.name + "Он сегодня ел: " + this.food);

    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Kotik");
        gav.show();

        System.out.println("There are black's food.");
        Cat black  = new Cat();
        black.eat("fish");
        black.giveNick("Vaska");
        black.show();
    }

}
