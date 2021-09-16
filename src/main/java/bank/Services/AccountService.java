package bank.Services;

import bank.GenericDao.HibernateUtil;
import bank.Model.Account;

public class AccountService {
    HibernateUtil<Account> accountHibernateUtil = new HibernateUtil();

    public void addAccount(Account account) {
        accountHibernateUtil.add(account);
    }

    public void update(Account account) {
        accountHibernateUtil.update(account);
    }

    public Account findByIBAN(Account account, int iban) {
        return accountHibernateUtil.findByIBAN(account, iban);
    }

    public void deleteAccount(Account account) {
        accountHibernateUtil.delete(account);
    }
}
