package consoleServise;

import Controller.UserController;
import Main.Main;
import Service.UserService;
import Util.Util;
import model.User;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceConsole {

    public static String login(String email, String passsword) {
        List<User> users = new UserService().getList();

        User user = null;
        for (User user1 : users) {
            if (user1.getEmail().equals(email) && user1.getPassword().equals(passsword)){
                user = user1;
                break;
            }
        }
        if (user!=null){
            Main.currentUser = user;
            return "You are logged in to your account";
        }else {
            return "Error";
        }
    }

    public static String register(String fullname, String userName, String email, String passsword) {
        List<User> users = new UserService().getList();

        Pattern pattern = Pattern.compile("[a-z]@gmail.com", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if (fullname.isEmpty() || userName.isEmpty() || email.isEmpty() || passsword.isEmpty()){
            return "One of the lines is the head";
        }
        if (!matcher.find()){
            return "Email entered incorrectly";
        }
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return "Such an email is registered";
            }
            if (user.getUserName().equals(userName)){
                return "Such an username is registered";
            }
        }

        User user = new User(fullname,userName,email,passsword, new Date());

        boolean add = new UserService().add(user);

        if (add){
            return "Successful registered";
        }else {
            return "Not successful registered";
        }


    }

    public static void profileMenu() {

        User user = new User();
        user = Main.currentUser;

        Integer number = 0;
        do {
            System.out.print("Full name: " + user.getFullName() + "\nUsername: " +
                    user.getUserName() + "\nEmail: " +
                    user.getEmail() + "\nCreate Date: " +
                    user.getCreateAt() + "\nPassword: ");
            for (int i = 0; i < user.getPassword().length(); i++) {
                System.out.print("*");
            }
            System.out.print("\n1.Edit\n" +
                    "2.My posts\n" +
                    "0.Exit\n" +
                    "Enter number: ");
            number = Util.SCANNER_INT.nextInt();

            switch (number){
                case 1:
                    UserController.profileEdit(user);
                    break;
                case 2:
                    PostServiceConsole.myPosts(user);
            }

        }while (number!=0);



    }

    public static void profileEdit(Integer number, User user) {
        switch (number){
            case 1:
                System.out.println("Enter full name: ");
                user.setFullName(Util.SCANNER_STR.nextLine());
                new UserService().edit(user);
                break;
            case 2:
                System.out.println("Enter username: ");
                user.setUserName(Util.SCANNER_STR.nextLine());
                new UserService().edit(user);
                break;
            case 3:
                System.out.println("Enter old password: ");
                String password = Util.SCANNER_STR.nextLine();
                if (user.getPassword().equals(password)){
                    System.out.println("Enter old password: ");
                    user.setPassword(Util.SCANNER_STR.nextLine());
                    new UserService().edit(user);
                }
                break;
        }
    }

    public static void search(String userName, String fullName) {
        List<User> users = new UserService().getList();
        boolean is = false;
        if(userName==null){
            for (User user : users) {
                if (user.getFullName().toLowerCase().contains(fullName.toLowerCase())){
                    System.out.println("Full name: " + user.getFullName() +
                                        "\nUsername: " + user.getUserName()+
                                        "\nCreate Date: " + user.getCreateAt());
                    is = true;
                }
            }
        }else {
            for (User user : users) {
                if (user.getUserName().toLowerCase().contains(userName.toLowerCase())){
                    System.out.println("Full name: " + user.getFullName() +
                            "\nUsername: " + user.getUserName()+
                            "\nCreate Date: " + user.getCreateAt());
                    is = true;
                }
            }
        }

        if (!is){
            System.out.println("This user does not exist");
        }
    }
}
