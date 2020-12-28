package ru.job4j.search;

import java.util.LinkedList;

public class Car {
    String model;
    int priority;
    public Car(String model, int priority) {
        this.model = model;
        this.priority = priority;

        }
        public Car(String model) {
        this.model = model;
    }
    public static void main(String[] args) {
        LinkedList<Car> cars = new LinkedList<Car>();
        Car ferrari = new Car("Ferrari 360 Spider", 0);
        Car bugatti = new Car("Bugatti Veyron", 1);
        Car lambo = new Car("Lamborghini Diablo", 2);
        Car ford = new Car("Ford Mustang", 3);
        Car subaru = new Car("Outback", 4);

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);
        cars.add(1, ford);
        //System.out.println(cars.peekFirst());

        //System.out.println(cars.peekLast());
        System.out.println(cars);
        Car hammer = new Car("Daeron", 1);
        cars.add(1, hammer);
        System.out.println(cars);
    }
    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + '}';
    }
}
