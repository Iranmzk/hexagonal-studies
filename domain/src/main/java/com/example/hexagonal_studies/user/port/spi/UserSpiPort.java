package com.example.hexagonal_studies.user.port.spi;

import com.example.hexagonal_studies.user.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserSpiPort {
    Mono<User> save(User user);

    Flux<User> find(User name);

    Mono<User> findById(String userId);
}
