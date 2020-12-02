package ru.job4j.profession;

public class Doctor extends Profession {
    private String treatment;
    private String examinatinon;

    public Doctor(String name, String surname, String education, String birthday, String treatment, String examinatinon) {
        super(name, surname, education, birthday);
        this.treatment = treatment;
        this.examinatinon = examinatinon;
    }

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
