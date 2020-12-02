package ru.job4j.profession;

public class Doctor extends Profession {
    private String treatment;
    private String examinatinon;

    public String getTreatment() {
        return treatment;
    }

    public String getExaminatinon() {
        return examinatinon;
    }

    /*public Diagnosis heal(Pacient pacient) {
        return null;
    }*/
}
