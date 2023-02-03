package com.example.hexagonal_studies.v1.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty
    private String name;

    private String LastName;

    private String email;
    @NotEmpty
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
