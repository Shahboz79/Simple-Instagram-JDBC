package consoleServise;

import Main.Main;
import Service.FollowerServece;
import Service.UserService;
import model.Follower;
import model.User;

import java.util.List;

public class FollowerServeceConsole {
    public static void getFollower() {
        List<Follower> followerList = new FollowerServece().getList();
        List<User> users = new UserService().getList();
        User user = Main.currentUser;

        String followers = "";
        int i = 0;
        for (Follower follower : followerList) {
            if (follower.getFollowerUserId().equals(user.getId())){
                for (User user1 : users) {
                    if (follower.getUserId().equals(user1.getId())){
                        followers += user1.getFullName() + "\n";
                        i++;
                    }
                }
            }
        }
        System.out.println("Followers: " + i + "\n" + followers);

    }

    public static String following(String username) {
        List<User> users = new UserService().getList();
        User user = Main.currentUser;

        for (User user1 : users) {
            if (user1.getUserName().equals(username)){
                new FollowerServece().add(new Follower(user.getId(),user1.getId()));
                return "Successful following";
            }
        }
        return "Error username";
    }
}
