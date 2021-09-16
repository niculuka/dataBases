package bank.UI;

import bank.Model.Account;
import bank.Services.AccountService;
import java.util.Scanner;
import lombok.*;

@Setter
@Getter
@ToString
public class AccountUI {
    private Account newAccount1;
    private Account newAccount2;
    AccountService accountService = new AccountService();
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public void addAccount1(UserUI userUI) {
        System.out.println("INSERT A FRIENDLY NAME FOR 'ACCOUNT 1': ");
        String friendly_name1 = scanner.next();
        System.out.println("INSERT BALANCE FOR 'ACCOUNT 1' : ");
        int balance1 = scanner.nextInt();
        newAccount1 = new Account(friendly_name1, balance1, userUI.getNewUser());
        accountService.addAccount(newAccount1);
        System.out.println("'ACCOUNT 1' HAS BEEN CREATED");
        System.out.println("=========================================================================================");
    }

    public void addAccount2(UserUI userUI) {
        System.out.println("INSERT A FRIENDLY NAME FOR 'ACCOUNT 2': ");
        String friendly_name2 = scanner.next();
        System.out.println("INSERT BALANCE FOR 'ACCOUNT 2' : ");
        int balance2 = scanner.nextInt();
        newAccount2 = new Account(friendly_name2, balance2, userUI.getNewUser());
        accountService.addAccount(newAccount2);
        System.out.println("'ACCOUNT 2' HAS BEEN CREATED");
        System.out.println("=========================================================================================");
    }



}
