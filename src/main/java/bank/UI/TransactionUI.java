package bank.UI;

import bank.Model.Account;
import bank.Model.Transaction;
import bank.Services.AccountService;
import bank.Services.TransactionService;

import java.util.Scanner;

public class TransactionUI {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    AccountService accountService = new AccountService();
    TransactionService transactionService = new TransactionService();

    public void transferMoney() {
        Account account1 = new Account();
        Account account2 = new Account();
        System.out.println("INSERT 'SOURCE' ACCOUNT NUMBER': ");
        int source = scanner.nextInt();
        System.out.println("INSERT 'DESTINATION' ACCOUNT NUMBER: ");
        int destination = scanner.nextInt();
        System.out.println("INSERT 'SUM' TO TRANSFER: ");
        int sum = scanner.nextInt();

        account1 = accountService.findByIBAN(account1, source);
        account2 = accountService.findByIBAN(account2, destination);
        Transaction transaction = new Transaction("Money", "10.12.2021", sum, account1, account2);

        if (account1.getBalance() >= transaction.getSum()) {
            account1.setBalance(account1.getBalance() - transaction.getSum());
            accountService.update(account1);
            account2.setBalance(account2.getBalance() + transaction.getSum());
            accountService.update(account2);
            transactionService.addTransaction(transaction);
            System.out.println("TRANSFER COMPLETED");
            System.out.println("=========================================================================================");
        } else {
            System.out.println("NOT ENOUGH MONEY IN ACCOUNT!");
            System.out.println("=========================================================================================");
        }
    }
}
