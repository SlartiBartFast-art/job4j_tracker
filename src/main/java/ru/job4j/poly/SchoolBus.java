package ru.job4j.poly;

public class SchoolBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass()
                + "Автобус перевозит школьников, двигается по скоростным рассам");

    }

    @Override
    public void passandger(int count) {
        count++;
    }

    @Override
    public double fuel(double fuel, double distance, double weightTrain) {
        double price = ((weightTrain * distance) * fuel) / 10000;
        return price;

    }
}
