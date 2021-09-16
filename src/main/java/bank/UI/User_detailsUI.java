package bank.UI;

import bank.Model.User_details;
import bank.Services.User_detailService;
import java.util.Scanner;

public class User_detailsUI {
    User_details user_details = new User_details();
    User_detailService user_detailService = new User_detailService();
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public void addUserDetails(UserUI userUI) {
        System.out.println("INSERT YOUR ADDRESS: ");
        String address = scanner.next();
        System.out.println("INSERT YOUR PHONE NUMBER: ");
        String phone = scanner.next();
        System.out.println("INSERT YOUR BIRTHDAY: ");
        String birthday = scanner.next();
        User_details user_details = new User_details(address, phone, birthday, userUI.getNewUser());
        user_detailService.addUser_detail(user_details);
        System.out.println("USER DETAILS SAVED");
        System.out.println("=========================================================================================");
    }

    public void readDetails() {
        System.out.println("INSERT A USER ID, TO SEE DETAILS: ");
        int id = scanner.nextInt();
        user_details = user_detailService.readUserDetails(user_details, id);
        System.out.println("ALL DETAILS: " + user_details);
        System.out.println("=========================================================================================");
    }


}
