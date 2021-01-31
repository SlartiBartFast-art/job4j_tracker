package ru.job4j.bank;
import java.util.Objects;
import java.util.Optional;

public class User {
    private Optional<String> passport;
    private Optional<String> username;

    public User(String passport, String username) {
        this.passport = Optional.of(passport);
        this.username = Optional.of(username);
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = Optional.ofNullable(passport);
    }

    public Optional<String> getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Optional.ofNullable(username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
