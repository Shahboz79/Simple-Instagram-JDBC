package model;

import java.util.UUID;

public class Following {
    private UUID id;
    private UUID userId;

    {
        id = UUID.randomUUID();
    }

    public Following(UUID userId) {
        this.userId = userId;
    }
}
