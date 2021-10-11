package bank.UI;

import bank.Model.Account_type;
import bank.Services.Account_typeService;
import java.util.Scanner;

public class Account_typeUI {
    Account_typeService account_typeService  = new Account_typeService();
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public void addAccount_Type1(AccountUI accountUI) {
        System.out.println("INSERT CURRENCY TYPE FOR 'ACCOUNT 1': ");
        String types = scanner.next();
        Account_type account_type1 = new Account_type(types, accountUI.getNewAccount1());
        account_typeService.addAccount_type(account_type1);
        System.out.println("'CURRENCY TYPE FOR ACCOUNT 1' has been set");
        System.out.println("=========================================================================================");
    }

    public void addAccount_Type2(AccountUI accountUI) {
        System.out.println("INSERT CURRENCY TYPE FOR 'ACCOUNT 2': ");
        String type2 = scanner.next();
        Account_type account_type2 = new Account_type(type2, accountUI.getNewAccount2());
        account_typeService.addAccount_type(account_type2);
        System.out.println("CURRENCY FOR 'ACCOUNT 2' HAS BEEN SET");
        System.out.println("=========================================================================================");
    }



}
