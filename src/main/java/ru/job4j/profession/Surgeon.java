package ru.job4j.profession;

public class Surgeon extends Doctor {
    private int stage;

    public Surgeon(String name, String surname, String education, String birthday,
                   String treatment, String examinatinon, int stage) {
        super(name, surname, education, birthday, treatment, examinatinon);
        this.stage = stage;
    }

}
