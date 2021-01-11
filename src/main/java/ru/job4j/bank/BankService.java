package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user1 = findByPassport(passport);
        if (user1 != null) {
            List<Account> accounts = users.get(user1);
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
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {

            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счет пользователя по реквизитам.
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счта пользователя
     * @return
     */
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

