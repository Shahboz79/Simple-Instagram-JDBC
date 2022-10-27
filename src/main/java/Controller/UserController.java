package Controller;

import Main.Main;
import Util.Util;
import consoleServise.FollowerServeceConsole;
import consoleServise.MessageServiceConsole;
import consoleServise.PostServiceConsole;
import consoleServise.UserServiceConsole;
import model.Follower;
import model.User;

public class UserController {
    public static void login() {
        System.out.print("Enter email: ");
        String email = Util.SCANNER_STR.nextLine();
        System.out.print("Enter password: ");
        String passsword = Util.SCANNER_STR.nextLine();

        String login = UserServiceConsole.login(email, passsword);
        System.out.println(login);
    }

    public static void register() {
        System.out.print("Enter full name:");
        String fullName = Util.SCANNER_STR.nextLine().trim();
        System.out.print("Enter user name: ");
        String userName = Util.SCANNER_STR.nextLine().trim();
        System.out.print("Enter email: ");
        String email = Util.SCANNER_STR.nextLine().trim();
        System.out.print("Enter password: ");
        String passsword = Util.SCANNER_STR.nextLine().trim();

        String register = UserServiceConsole.register(fullName, userName, email, passsword);

        System.out.println(register);


    }

    public static void menu() {
        Integer number = 0;
        do {
            System.out.print("1.Profile\n" +
                    "2.Search\n" +
                    "3.Post\n" +
                    "4.Add post\n" +
                    "5.Message\n" +
                    "6.Check message\n" +
                    "7.Followers\n" +
                    "8.Following\n" +
                    "0.Exit\n" +
                    "Enter number: ");
            number = Util.SCANNER_INT.nextInt();

            switch (number){
                case 1:
                    UserServiceConsole.profileMenu();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    PostServiceConsole.posts();
                    break;
                case 4:
                    PostController.addPost();
                    break;
                case 5:
                    MessageController.writeMessage();
                    break;
                case 6:
                    MessageServiceConsole.checkedMessage();
                    break;
                case 7:
                    FollowerServeceConsole.getFollower();
                    break;
                case 8:
                    FollowerController.following();

            }
        }while (number!=0);
        Main.currentUser = null;
    }

    private static void search() {
        Integer number = 0;
        do {
            System.out.print("1.User search\n" +
                    "2.Post search\n" +
                    "0.Exit\n" +
                    "Enter number: ");
            number = Util.SCANNER_INT.nextInt();

            switch (number){
                case 1:
                    searchUser();
                    break;
                case 2:
                    PostController.searchPost();
                    break;
            }
        }while (number!=0);

    }

    private static void searchUser() {
        Integer number = 0;
        do {
            System.out.print("1.Full name search\n" +
                    "2.Username search\n" +
                    "0.Exit\n" +
                    "Enter number:");
            number = Util.SCANNER_INT.nextInt();

            switch (number){
                case 1:
                    System.out.print("Enter full name: ");
                    String fullName = Util.SCANNER_STR.nextLine().trim();
                    UserServiceConsole.search(null,fullName);
                    break;
                case 2:
                    System.out.print("Enter userName: ");
                    String userName = Util.SCANNER_STR.nextLine();
                    UserServiceConsole.search(userName,null);
                    break;
            }
        }while (number!=0);

    }

    public static void profileEdit(User user) {
        Integer number = 0;
        do {
            System.out.print("1.Full name\n" +
                    "2.Username\n" +
                    "3.Password\n" +
                    "0.Exit\n" +
                    "Enter number: ");

            number = Util.SCANNER_INT.nextInt();

            UserServiceConsole.profileEdit(number,user);
        }while (number!=0);

    }
}
