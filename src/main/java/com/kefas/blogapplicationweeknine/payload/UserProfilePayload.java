package com.kefas.blogapplicationweeknine.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfilePayload {

    private Long id;
    private String firstName;
    private String lastName;
    private Instant joinedAt;
    private String email;
    private String phone;

    public UserProfilePayload(Long id, String username, String firstName, String lastName, String email, String phone, Long postCount) {
    }
}
