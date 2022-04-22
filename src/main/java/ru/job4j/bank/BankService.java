package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет клиента по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает клиента
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет аккаунт по номеру паспорта и реквизиту
     * @param passport номер паспорта клиента
     * @param requisite реквизит аккаунта
     * @return возвращает аккаунт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDst = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent()
                && accountDst.isPresent()
                && accountSrc.get().getBalance() >=  amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDst.get().setBalance(accountDst.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
