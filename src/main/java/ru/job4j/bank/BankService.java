package ru.job4j.bank;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();


    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user1 = findByPassport(passport); // нашли по паспорту
        if (user1 != null) {
            List<Account> accounts = users.get(user1);
            if (!accounts.contains(account)) {
            accounts.add(account);
            }

        }

    }

/**найти пользователя по паспорту*/
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {

            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }
/**Этот метод идет счет пользователя по реквизитам. Сначала нужно найти пользователя.
 *  Потом получить список счетов этого пользователя и в нем найти нужный счет.
 * */
    public Account findByRequisite(String passport, String requisite) {
        User user1 = findByPassport(passport);
        if (user1 != null) {

                List<Account> accounts = users.get(user1); //получили список счетов

            for (int i = 0; i < accounts.size(); i++) {
                if (requisite.equals(accounts.get(i).getRequisite())) {
                    return accounts.get(i);
                }
            }

        }
        return null;
    }
/**Метод для перечисления денег с одного счёта на другой счёт.
 * */
    public boolean transferMoney(String srcPassport, String srcRequisite, // откуда
                                 String destPassport, String destRequisite, double amount) { // куда
        boolean rsl = false;

            Account accountSrc = findByRequisite(srcPassport, srcRequisite); // нашли конкретный счет

        Account accountDest = findByRequisite(destPassport, destRequisite);

                if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
                   accountDest.setBalance(accountDest.getBalance() + accountSrc.getBalance());
                   accountSrc.setBalance(accountSrc.getBalance() - accountDest.getBalance());
                   rsl = true;
                }
                return rsl;

        }

    }

