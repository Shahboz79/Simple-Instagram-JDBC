package Service;

import model.Message;
import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageService implements Base<Message> {
    @Override
    public boolean add(Message message) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into messages(id,user_id, body,to_whon_user_id) values (?,?,?,?)")
        ) {

            preparedStatement.setObject(1, message.getId());
            preparedStatement.setObject(2, message.getUserId());
            preparedStatement.setString(3, message.getBody());
            preparedStatement.setObject(4, message.getToUserId());


            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Message> getList() {
        List<Message> messages = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet
                    = statement.executeQuery("select * from messages");
            while (resultSet.next()) {
                Message message = new Message();
                message.get(resultSet);
                messages.add(message);
            }
            return messages;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Message getById(UUID id) {
        return null;
    }
}
