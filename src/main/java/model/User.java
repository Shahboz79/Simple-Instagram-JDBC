package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.sql.ResultSet;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User implements Base {
    private UUID id;
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private Date createAt;
    private UUID messageId;

    {
        id = UUID.randomUUID();
    }

    public User(String fullName, String userName, String email, String password, Date createAt) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
    }

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = UUID.fromString(resultSet.getString("id"));
            this.fullName = resultSet.getString("fullname");
            this.email = resultSet.getString("email");
            this.password = resultSet.getString("password");
            this.createAt = resultSet.getDate("created_at");
            String message_id = resultSet.getString("message_id");
            if (message_id!=null){
                this.messageId = UUID.fromString(message_id);
            }
            this.userName = resultSet.getString("username");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
