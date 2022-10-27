package model;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Comment {
    private UUID id;
    private String body;
    private UUID userId;
    private Date wraitedAt;

    {
        id = UUID.randomUUID();
    }

    public Comment(String body, UUID userId, Date wraitedAt) {
        this.body = body;
        this.userId = userId;
        this.wraitedAt = wraitedAt;
    }
}
