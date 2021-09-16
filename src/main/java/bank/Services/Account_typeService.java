package bank.Services;

import bank.GenericDao.HibernateUtil;
import bank.Model.Account_type;

public class Account_typeService {
    HibernateUtil<Account_type> account_typeHibernateUtil = new HibernateUtil();

    public void addAccount_type(Account_type account_type) {
        account_typeHibernateUtil.add(account_type);
    }

    public Account_type findById_Account_type(Account_type account_type, int id) {
        return account_typeHibernateUtil.findById(account_type, id);
    }

    public void deleteAccount_type(Account_type account_type) {
        account_typeHibernateUtil.delete(account_type);
    }
}
