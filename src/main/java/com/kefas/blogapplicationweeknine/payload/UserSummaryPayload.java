package com.kefas.blogapplicationweeknine.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSummaryPayload {
    private Long id;

    private String email;

    private String firstname;

    private String lastname;
}
