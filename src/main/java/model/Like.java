package model;

import java.util.UUID;

public class Like {
    private UUID id;
    private UUID userId;
    private UUID typeId;

    {
        id = UUID.randomUUID();
    }

    public Like(UUID userId, UUID typeId) {
        this.userId = userId;
        this.typeId = typeId;
    }
}
