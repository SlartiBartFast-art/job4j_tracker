package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFioId("Ivanov Ivan");
        student.setGroup(358);
        student.setReceiptDate("02.12.2020");
        System.out.println("FIO: " + student.getFioId() + " Group №: "
                + student.getGroup() + " Date reception: "
                + student.getReceiptDate());
    }
}
