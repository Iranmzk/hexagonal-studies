package com.example.hexagonal_studies.repository;

import com.example.hexagonal_studies.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<UserEntity> find(UserEntity entity) {
        final Query query = new Query();
        query.fields().include("name");
        query.addCriteria(Criteria.where("name")
                .regex(StringUtils.capitalize(entity.getName())));

        return reactiveMongoTemplate.find(query, UserEntity.class);
    }
}
