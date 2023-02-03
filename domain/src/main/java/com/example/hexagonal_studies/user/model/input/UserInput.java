package com.example.hexagonal_studies.user.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInput {
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
}
