package com.example.hexagonal_studies;

import com.example.hexagonal_studies.entity.UserEntity;
import com.example.hexagonal_studies.user.model.User;

public class UserMapper {

    public static UserEntity mapToEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .LastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickName(user.getNickName())
                .address(UserEntity.Address.builder()
                        .street(user.getAddress().street())
                        .number(user.getAddress().number())
                        .city(user.getAddress().city())
                        .state(user.getAddress().state())
                        .country(user.getAddress().country())
                        .zipCode(user.getAddress().zipCode())
                        .build())
                .build();
    }

    public static User toDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .LastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .nickName(userEntity.getNickName())
                .address(User.Address.builder()
                        .street(userEntity.getAddress().street())
                        .number(userEntity.getAddress().number())
                        .city(userEntity.getAddress().city())
                        .state(userEntity.getAddress().state())
                        .country(userEntity.getAddress().country())
                        .zipCode(userEntity.getAddress().zipCode())
                        .build())
                .build();
    }
}
