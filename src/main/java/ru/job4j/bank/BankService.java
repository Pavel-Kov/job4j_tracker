package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает действия банковских сервисов
 * @author Pavel
 * @version 1.0
 */
public class BankService {

    /**
     * Данные клиента храняться в структуре ключ-значение
     * Ключ клиент, значение - список аккаунтов клиента
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Мотод добавляет клиента банка и создает пустой список аккаунтов
     * @param user клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод ищет клиента и добавляет аккаунт
     * @param passport номер паспорта клиента
     * @param account аккаунта клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет клиента по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает клиента
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет аккаунт по номеру паспорта и реквизиту
     * @param passport номер паспорта клиента
     * @param requisite реквизит аккаунта
     * @return возвращает аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит средства с аккаунта а аккаунт, если их достаточно.
     * @param srcPassport номер паспорта отправляющего клиента
     * @param srcRequisite реквизит отправляющего аккаунта
     * @param destPassport номер паспорта принимающего клиента
     * @param destRequisite реквизит принимающего аккаунта
     * @param amount размер перевода
     * @return возвращает выполен перевод или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDst = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDst != null && accountSrc.getBalance() >=  amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDst.setBalance(accountDst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
