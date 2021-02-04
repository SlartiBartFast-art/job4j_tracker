package ru.job4j.stream;


import java.util.Objects;

public class Account {
    private String name;
    private String surname;
    private byte age;
    private String gender;
    private int passport;
    private String address;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String gender;
        private int passport;
        private String address;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildSAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildPassport(int passport) {
            this.passport = passport;
            return this;
        }

        Builder buildAddress(String address) {
            this.address = address;
            return this;
        }

        Account build() {
            Account account = new Account();
            account.name = name;
            account.surname = surname;
            account.age = age;
            account.gender = gender;
            account.passport = passport;
            account.address = address;
            return account;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return age == account.age
                && passport == account.passport
                && Objects.equals(name, account.name)
                && Objects.equals(surname, account.surname)
                && Objects.equals(gender, account.gender)
                && Objects.equals(address, account.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender, passport, address);
    }

    @Override
    public String toString() {
        return "Account{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", gender='" + gender + '\''
                + ", passport=" + passport
                + ", address='" + address + '\''
                + '}';
    }
}
