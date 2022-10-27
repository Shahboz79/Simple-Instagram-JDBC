package consoleServise;

import Service.PostService;
import Service.UserService;
import model.Post;
import model.User;

import java.util.List;
import java.util.UUID;

public class PostServiceConsole {

    public static void posts() {
        List<Post> postList = new PostService().getList();
        List<User> users = new UserService().getList();

        boolean is = false;
        for (Post post : postList) {
            for (User user : users) {
                if (post.getUser_id().equals(user.getId())) {
                    System.out.println("User: " + user.getFullName());
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Body: " + post.getBody() + "\n");
                    is = true;
                }
            }
        }
        if (!is){
            System.out.println("No posts");
        }
    }

    public static void myPosts(User user) {
        List<Post> postList = new PostService().getList();

        boolean is = false;
        for (Post post : postList) {
            if (post.getUser_id().equals(user.getId())) {
                System.out.println("User: " + user.getFullName());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Body: " + post.getBody() + "\n");
                is = true;
            }
        }
        if (!is){
            System.out.println("No posts");
        }
    }

    public static String addPost(String title, String body, UUID user_id) {
        if (title.isEmpty()) {
            return "Title empty";
        }
        if (body.isEmpty()) {
            return "Body empty";
        }

        new PostService().add(new Post(title, body, user_id));
        return "Successful add post";
    }

    public static void search(String title) {
        List<Post> postList = new PostService().getList();
        List<User> users = new UserService().getList();

        boolean is = false;
        for (Post post : postList) {
            if (post.getTitle().toLowerCase().contains(title.toLowerCase())) {
                for (User user : users) {
                    if (user.getId().equals(post.getUser_id())) {
                        System.out.println("User: " + user.getFullName() +
                                "\nTitle: " + post.getTitle() +
                                "\nBody: " + post.getBody() + "\n-------------");
                        is = true;
                    }
                }
            }
        }
        if (!is){
            System.out.println("This post does not exist");
        }
    }
}