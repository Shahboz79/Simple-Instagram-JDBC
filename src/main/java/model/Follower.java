package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class Follower implements Base {
    private UUID id;
    private UUID userId;
    private UUID followerUserId;

    {
        id = UUID.randomUUID();
    }

    public Follower(UUID userId, UUID followerUserId) {
        this.userId = userId;
        this.followerUserId = followerUserId;
    }

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = UUID.fromString(resultSet.getString("id"));
            this.userId = UUID.fromString(resultSet.getString("user_id"));
            this.followerUserId = UUID.fromString(resultSet.getString("follower_user_id"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
