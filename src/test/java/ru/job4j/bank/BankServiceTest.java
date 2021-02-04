package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Optional;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Optional<User> rsl = bank.findByPassport("3434");
        // assertThat(rsl.get(), is(user));
        rsl.ifPresent(user1 -> assertThat((bank.findByPassport("3434")).get(), is(user)));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> rsl = bank.findByRequisite("34", "5546");
        rsl.ifPresent(account -> assertNull(bank.findByRequisite("34", "5546").get()));

    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> rsl = bank.findByRequisite("3434", "5546");
        rsl.ifPresent(account -> assertThat(account.getBalance(), is(150D)));
        /*if (rsl.isPresent()) {
            assertThat(rsl.get().getBalance(), is(150D));
        } else {
            System.out.println("\"Element not found.\"");
        }*/
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }
}
