package bank;

import bank.GenericDao.HibernateUtil;
import bank.UI.*;
import org.hibernate.Session;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        UserUI userUI = new UserUI();
        User_detailsUI user_detailsUI = new User_detailsUI();
        AccountUI accountUI = new AccountUI();
        Account_typeUI account_typeUI = new Account_typeUI();
        TransactionUI transactionUI = new TransactionUI();
//----------------------------------------------------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Choose operation type!");
        while (true) {
            System.out.println("[1] - Create");
            System.out.println("[2] - Read");
            System.out.println("[3] - Update");
            System.out.println("[4] - Delete");
            System.out.println("[5] - Transfer money");
            String option = scanner.next();
            switch (option) {
                case "1" -> {
                    userUI.addUser();
                    user_detailsUI.addUserDetails(userUI);
                    accountUI.addAccount1(userUI);
                    account_typeUI.addAccount_Type1(accountUI);
                    accountUI.addAccount2(userUI);
                    account_typeUI.addAccount_Type2(accountUI);
                }
                case "2" -> {
                    user_detailsUI.readDetails();
                }
                case "3" -> {
                    userUI.updateUser();
                }
                case "4" -> {
                    userUI.deleteUser();
                }
                case "5" -> {
                    transactionUI.transferMoney();
                }
            }
        }
    }
}
