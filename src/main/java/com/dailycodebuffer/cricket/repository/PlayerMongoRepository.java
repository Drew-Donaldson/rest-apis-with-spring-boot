package com.dailycodebuffer.cricket.repository;

import com.dailycodebuffer.cricket.entity.PlayerEntity;
import com.dailycodebuffer.cricket.entity.PlayerMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerMongoRepository extends MongoRepository<PlayerMongoEntity, Integer> {
    List<PlayerEntity> findAllByRole(String role);
}
