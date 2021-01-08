package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        this.fullUp(100);
        this.passanger(10);
    }

    @Override
    public void passanger(int cout) {
        cout++;
    }

    @Override
    public double fullUp(double fuel) {
        double price = fuel * 47.50;

        return price;
    }
}
