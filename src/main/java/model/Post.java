package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Post implements Base {
    private UUID id;
    private String title;
    private String body;
    private UUID user_id;

    {
        id = UUID.randomUUID();
    }

    public Post(String title, String body, UUID user_id) {
        this.title = title;
        this.body = body;
        this.user_id = user_id;
    }

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = UUID.fromString(resultSet.getString("id"));
            this.title = resultSet.getString("title");
            this.body = resultSet.getString("body");
            this.user_id = UUID.fromString(resultSet.getString("post_user_id"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
