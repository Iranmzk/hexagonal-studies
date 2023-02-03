package com.example.hexagonal_studies.user;

import com.example.hexagonal_studies.user.model.User;
import com.example.hexagonal_studies.user.port.api.UserApiPort;
import com.example.hexagonal_studies.user.port.spi.UserSpiPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UserService implements UserApiPort {

    private final UserSpiPort userSpiPort;
    @Override
    public Mono<User> save(User user) {
        return userSpiPort.save(user);
    }

    @Override
    public Flux<User> findByName(User name) {
        return userSpiPort.find(name);
    }

    @Override
    public Mono<User> findById(String userId) {
        return userSpiPort.findById(userId);
    }


}
