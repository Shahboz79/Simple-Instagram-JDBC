package Service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService implements Base<User> {

    @Override
    public boolean add(User user) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into users(id,fullname, email,password, created_at, message_id, username) values (?,?,?,?,?,?,?)")
        ) {

            preparedStatement.setObject(1, user.getId());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, new Date(user.getCreateAt().getTime()));
            preparedStatement.setObject(6, user.getMessageId());
            preparedStatement.setString(7, user.getUserName());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getList() {
        List<User> userList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet
                    = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = new User();
                user.get(resultSet);
                userList.add(user);
            }
            return userList;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

    public void edit(User user){
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("update users set fullname = ?,email = ?, password = ?,username = ? where id = ?")
        ) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setObject(5, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
