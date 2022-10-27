package Controller;

import Service.UserService;
import Util.Util;
import consoleServise.MessageServiceConsole;
import model.User;

import java.util.List;

public class MessageController {
    public static void writeMessage() {
        List<User> users = new UserService().getList();

        for (User user : users) {
            System.out.println("Full name: " + user.getFullName() +
                                "\nUsername: " + user.getUserName() + "\n-----------");
        }
        System.out.print("Enter username: ");
        String userName = Util.SCANNER_STR.nextLine();

        System.out.print("Enter body: ");
        String body = Util.SCANNER_STR.nextLine();

        String writeMessage = MessageServiceConsole.writeMessage(userName, body);
        System.out.println(writeMessage);
    }
}
