package Controller;

import Main.Main;
import Service.PostService;
import Util.Util;
import consoleServise.PostServiceConsole;
import model.Post;
import model.User;

public class PostController {
    public static void addPost() {
        User user = Main.currentUser;

        System.out.print("Enter title: ");
        String title = Util.SCANNER_STR.nextLine().trim();

        System.out.print("Enter body: ");
        String body = Util.SCANNER_STR.nextLine().trim();

        String addPost = PostServiceConsole.addPost(title, body, user.getId());
        System.out.println(addPost);
    }

    public static void searchPost() {
        System.out.print("Enter title: ");
        String title = Util.SCANNER_STR.nextLine();
        PostServiceConsole.search(title);
    }
}
