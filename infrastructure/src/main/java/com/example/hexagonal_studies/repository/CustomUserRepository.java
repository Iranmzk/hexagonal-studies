package com.example.hexagonal_studies.repository;

import com.example.hexagonal_studies.entity.UserEntity;
import reactor.core.publisher.Flux;

public interface CustomUserRepository {
    Flux<UserEntity> find(UserEntity entity);
}
