package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class Message implements Base {
    private UUID id;
    private UUID userId;
    private String body;
    private UUID toUserId;

    {
        id = UUID.randomUUID();
    }

    public Message(UUID userId, String body, UUID toUserId) {
        this.userId = userId;
        this.body = body;
        this.toUserId = toUserId;
    }

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = UUID.fromString(resultSet.getString("id"));
            this.userId = UUID.fromString(resultSet.getString("user_id"));
            this.body = resultSet.getString("body");
            this.toUserId = UUID.fromString(resultSet.getString("to_whon_user_id"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
