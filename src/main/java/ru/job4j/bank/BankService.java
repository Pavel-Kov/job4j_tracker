package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDst = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDst != null && accountSrc.getBalance() >=  amount) {
            int indexSrc = users.get(findByPassport(srcPassport)).indexOf(accountSrc);
            int indexDst = users.get(findByPassport(destPassport)).indexOf(accountDst);
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDst.setBalance(accountDst.getBalance() + amount);
            users.get(findByPassport(srcPassport)).set(indexSrc, accountSrc);
            users.get(findByPassport(destPassport)).set(indexDst, accountDst);
            rsl = true;
        }
        return rsl;
    }
}
