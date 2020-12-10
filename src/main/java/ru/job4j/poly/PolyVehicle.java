package ru.job4j.poly;

public class PolyVehicle {
    public static void main(String[] args) {
        Vehicle schoolBus = new SchoolBus();
        Vehicle airplan = new Airplan();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{schoolBus, airplan, train};
        for (Vehicle vi: vehicles) {
            vi.move();
        }
    }
}
