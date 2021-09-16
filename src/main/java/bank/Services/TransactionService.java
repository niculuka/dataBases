package bank.Services;

import bank.GenericDao.HibernateUtil;
import bank.Model.Transaction;

public class TransactionService {
    HibernateUtil<Transaction> transactionHibernateUtil = new HibernateUtil();

    public void addTransaction(Transaction transaction) {
        transactionHibernateUtil.add(transaction);
    }


}
