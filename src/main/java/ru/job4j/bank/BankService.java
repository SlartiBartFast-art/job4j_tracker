package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Класс описывает:
 * Регистрацию пользователя.
 * Удаление пользователя из системы.
 * Добавление пользователю банковского счета.
 * Перевод денег с одного банковского счета на другой счет.
 * @author DIMA KAZUMU
 * @version 1.0
 */
public class BankService {

     /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     * Хранение задания осуществляется в коллекции типа List;
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить пользователя в систему.
     * @param user Пользователь банковского счета
     * {@link ru.job4j.bank.User}
     */
    public void addUser(User user) {

        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод производит добавление нового счета к пользователю
     * @param passport паспортные данные пользователя
     * @param account новый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user1 = findByPassport(passport);

        if (user1.isPresent()) {
            User user = user1.get();
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорт
     * @param passport паспортные данные пользователя
     * @return возвращает найденного пользователя или null если такого пользователя нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();

    }
//.orElse(null); было выше до обертывания в Optional
   /* public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }*/

    /**
     * Метод осуществляет поиск счет пользователя по реквизитам.
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счта пользователя
     * @return
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user1 = findByPassport(passport);
        //Account rsl =
        if (user1.isPresent()) {
            User user = user1.get();
           return users.get(user)
                   .stream()
                   .filter(account -> account.getRequisite().equals(requisite))
                   .findFirst();

        }
        return Optional.empty();
    }
//.orElse(null); было до обертывания в Optional
   /* public Account findByRequisite(String passport, String requisite) {
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
    }*/

    /**
     * Метод позволяет осуществлять перечисления денег с одного счёта на другой счёт.
     * @param srcPassport паспортные данные пользователя счета с которго осуществляется перевод
     * @param srcRequisite реквизиты счета пользователя с которго осуществляется перевод
     * @param destPassport паспортные данные пользователя счета на которго осуществляется перевод
     * @param destRequisite реквизиты счета пользователя на который осуществляется перевод
     * @param amount сумма баланса счета
     * @return true перечисление было выполнено успешно.
     *         false если перечисление не было произведено.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, // откуда
                                 String destPassport, String destRequisite, double amount) { // куда
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite); // нашли конкретный счет
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent()
                && accountSrc.get().getBalance() >= amount) {
            accountDest.get().setBalance(accountDest.get().getBalance() + accountSrc.get().getBalance());
            accountSrc.get().setBalance(accountSrc.get().getBalance() - accountDest.get().getBalance());
            rsl = true;
        }
        return rsl;
    }
}

