package Controller;

import Service.FollowerServece;
import Service.UserService;
import Util.Util;
import consoleServise.FollowerServeceConsole;
import model.Follower;
import model.User;

import java.util.List;

public class FollowerController {
    public static void following() {
        List<User> users = new UserService().getList();
        for (User user : users) {
            System.out.println("Full name: " + user.getFullName() +
                    "\nUsername: " + user.getUserName() + "\n------------");
        }
        System.out.print("Enter username: ");
        String username = Util.SCANNER_STR.nextLine();

        String following = FollowerServeceConsole.following(username);
        System.out.println(following);
    }
}
