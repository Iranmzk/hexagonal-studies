package com.example.hexagonal_studies.v1.user;

import com.example.hexagonal_studies.user.model.User;
import com.example.hexagonal_studies.v1.user.request.UserRequest;
import com.example.hexagonal_studies.v1.user.response.UserResponse;

public class UserControllerMapper {

    public static User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .LastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .nickName(userRequest.getNickName())
                .address(User.Address.builder()
                        .street(userRequest.getAddress().street())
                        .number(userRequest.getAddress().number())
                        .city(userRequest.getAddress().city())
                        .state(userRequest.getAddress().state())
                        .country(userRequest.getAddress().country())
                        .zipCode(userRequest.getAddress().zipCode())
                        .build())
                .build();
    }

    public static UserResponse userToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickName(user.getNickName())
                .address(UserResponse.Address.builder()
                        .street(user.getAddress().street())
                        .number(user.getAddress().number())
                        .city(user.getAddress().city())
                        .state(user.getAddress().state())
                        .country(user.getAddress().country())
                        .zipCode(user.getAddress().zipCode())
                        .build())
                .build();
    }
}
