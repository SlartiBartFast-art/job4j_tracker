package ru.job4j.stream;

import java.util.Objects;

public class Address {

    private static String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getApartment() {
        return apartment;
    }

        public int getHome() {
        return home;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == .score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }*/
    @Override
    public boolean equals(Address address) {
        Address address1 = (Address) address;
        return address.equals(address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }


}
