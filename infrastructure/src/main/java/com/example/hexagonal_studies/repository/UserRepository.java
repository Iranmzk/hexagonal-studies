package com.example.hexagonal_studies.repository;

import com.example.hexagonal_studies.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String>, CustomUserRepository {
}
