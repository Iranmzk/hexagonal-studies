package com.example.hexagonal_studies.entity;

import com.example.hexagonal_studies.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "User")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String LastName;
    private String email;
    private String password;
    private String nickName;
    private Address address;

    @Builder
    public record Address(String street,
                          String number,
                          String city,
                          String state,
                          String country,
                          String zipCode
    ) {
    }

    public static UserEntity fromDomain(User user) {
        return UserEntity.builder()
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
}
