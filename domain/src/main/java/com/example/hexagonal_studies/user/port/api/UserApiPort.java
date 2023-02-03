package com.example.hexagonal_studies.user.port.api;

import com.example.hexagonal_studies.user.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApiPort {
    Mono<User> save(User user);

    Flux<User> findByName(User name);

    Mono<User> findById(String userId);
}
