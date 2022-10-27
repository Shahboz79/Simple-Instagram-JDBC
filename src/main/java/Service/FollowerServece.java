package Service;

import model.Follower;
import model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FollowerServece implements Base<Follower> {
    @Override
    public boolean add(Follower follower) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into follower(id,user_id,follower_user_id) values (?,?,?)")
        ) {

            preparedStatement.setObject(1, follower.getId());
            preparedStatement.setObject(2, follower.getUserId());
            preparedStatement.setObject(3, follower.getFollowerUserId());


            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Follower> getList() {
        List<Follower> followers = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet
                    = statement.executeQuery("select * from follower");
            while (resultSet.next()) {
                Follower follower = new Follower();
                follower.get(resultSet);
                followers.add(follower);
            }
            return followers;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Follower getById(UUID id) {
        return null;
    }
}
