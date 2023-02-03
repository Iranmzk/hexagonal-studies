package com.example.hexagonal_studies.v1.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String email;
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
