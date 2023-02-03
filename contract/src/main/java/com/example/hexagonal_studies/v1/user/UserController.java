package com.example.hexagonal_studies.v1.user;

import com.example.hexagonal_studies.user.port.api.UserApiPort;
import com.example.hexagonal_studies.v1.user.request.UserRequest;
import com.example.hexagonal_studies.v1.user.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {

    private UserApiPort service;

    @PostMapping
    public Mono<UserResponse> create(@RequestBody UserRequest userRequest) {
        return service.save(UserControllerMapper.userRequestToUser(userRequest))
                .map(UserControllerMapper::userToUserResponse);
    }

    @GetMapping
    public Flux<UserResponse> findByName(@Valid @RequestParam UserRequest name) {
        return service.findByName(UserControllerMapper.userRequestToUser(name))
                .map(UserControllerMapper::userToUserResponse);
    }

    @GetMapping("/search")
    public Mono<UserResponse> findById(String userId) {
        return service.findById(userId)
                .map(UserControllerMapper::userToUserResponse);
    }

}
