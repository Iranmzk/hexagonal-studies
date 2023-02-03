package com.example.hexagonal_studies;

import com.example.hexagonal_studies.repository.UserRepository;
import com.example.hexagonal_studies.user.model.User;
import com.example.hexagonal_studies.user.port.spi.UserSpiPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class UserSpiImpl implements UserSpiPort {
    private final UserRepository userRepository;

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(UserMapper.mapToEntity(user))
                .map(UserMapper::toDomain);
    }

    @Override
    public Flux<User> find(User name) {
        return userRepository.find(UserMapper.mapToEntity(name))
                .map(UserMapper::toDomain);
    }

    @Override
    public Mono<User> findById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::toDomain);
    }
}
