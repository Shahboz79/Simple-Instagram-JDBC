package consoleServise;

import Main.Main;
import Service.MessageService;
import Service.UserService;
import model.Message;
import model.User;

import java.util.List;

public class MessageServiceConsole {
    public static String writeMessage(String userName, String body) {
        List<User> users = new UserService().getList();
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                new MessageService().add(new Message(Main.currentUser.getId(), body, user.getId()));
                return "Successful write message";
            }
        }
        return "Error username";
    }

    public static void checkedMessage() {
        User user = Main.currentUser;
        List<Message> messages = new MessageService().getList();
        List<User> userList = new UserService().getList();

        boolean is = false;
        for (Message message : messages) {
            if (message.getToUserId().equals(user.getId())) {
                for (User user1 : userList) {
                    if (user1.getId().equals(message.getUserId())) {
                        System.out.println("Full name: " + user1.getFullName() +
                                            "\nBody: " + message.getBody() + "\n-----------");
                        is = true;
                        break;
                    }
                }
            }
        }
        if (!is){
            System.out.println("No one wrote you");
        }
    }
}
