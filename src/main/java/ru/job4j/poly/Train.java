package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        this.fuel(200, 1537, 1000000);
        this.passandger(10);
        System.out.println(getClass() + "Едет безшумно, перевозит пассажиров по рельсам");
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
