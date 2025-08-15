package com.dailycodebuffer.cricket.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "player")
public class PlayerMongoEntity {

    @Id
    private Integer playerId;
    private String name;
    private String role;
}
