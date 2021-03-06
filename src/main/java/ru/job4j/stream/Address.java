package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Address implements Comparator<Address> {

    private String city;
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

    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{"
                + "city=" + city
                + "street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }
}
