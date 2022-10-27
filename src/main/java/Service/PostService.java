package Service;

import model.Post;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostService implements Base<Post> {

    @Override
    public boolean add(Post post) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into posts(id,title, body,post_user_id) values (?,?,?,?)")
        ) {

            preparedStatement.setObject(1, post.getId());
            preparedStatement.setString(2, post.getTitle());
            preparedStatement.setString(3, post.getBody());
            preparedStatement.setObject(4, post.getUser_id());


            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Post> getList() {
        List<Post> posts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet
                    = statement.executeQuery("select * from posts");
            while (resultSet.next()) {
                Post post = new Post();
                post.get(resultSet);
                posts.add(post);
            }
            return posts;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Post getById(UUID id) {
        return null;
    }
}
