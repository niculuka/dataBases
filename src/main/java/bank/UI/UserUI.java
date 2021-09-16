package bank.UI;

import bank.Model.User;
import bank.Services.UserService;
import java.util.Scanner;
import lombok.*;

@Setter
@Getter
@ToString
public class UserUI {
    private User newUser;
    private User user = new User();
    private UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");


    public void addUser() {
        System.out.println("INSERT YOUR NAME: ");
        String name = scanner.next();
        System.out.println("INSERT A USER NAME: ");
        String username = scanner.next();
        System.out.println("INSERT A PASSWORD: ");
        String password = scanner.next();
        System.out.println("INSERT YOUR EMAIL: ");
        String email = scanner.next();
        newUser = new User(name, username, password, email);
        userService.addUser(newUser);
        System.out.println("USER CREATED");
        System.out.println("=========================================================================================");
    }

    public void updateUser() {
        System.out.println("SELECT A USER ID: ");
        int id = scanner.nextInt();
        System.out.println("INSERT YOUR EMAIL: ");
        String email = scanner.next();
        user = userService.findById_User(user, id);
        user.setEmail(email);
        userService.update(user);
        System.out.println("EMAIL " + email + " FOR ID " + id + " HAS BEEN UPDATED");
        System.out.println("=========================================================================================");
    }

    public void deleteUser() {
        int exit = 0;
        while (exit == 0) {
            int id;
            System.out.println("SELECT A 'USER ID' TO DELETE: ");
            id = scanner.nextInt();
            System.out.println("[1] - DELETE USER WITH ID '" + id + "' ???");
            System.out.println("[2] - EXIT");
            String yes_no = scanner.next();
            switch (yes_no) {
                case "1": {
                    user = userService.findById_User(user, id);
                    userService.deleteUser(user);
                    System.out.println("USER " + id + " HAS BEEN DELETED");
                    System.out.println("=============================================================================");
                    exit = 1;
                }
                break;
                case "2": {
                    System.out.println("EXITING...");
                    System.out.println("=============================================================================");
                    exit = 1;
                }
                break;
            }
        }
    }
}
