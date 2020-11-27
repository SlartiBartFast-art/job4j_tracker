package ru.job4j.oop;

public class Battery {
    private int value;

    public Battery(int size) {
        this.value = size;
    }

    public void exchange(Battery another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Battery pow = new Battery(45);
        Battery cell = new Battery(37);
        pow.exchange(cell);
        System.out.println(pow.value);

    }
}
