package com.kefas.blogapplicationweeknine.dto;

import com.kefas.blogapplicationweeknine.enums.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class UserDto{

    @NotBlank(message = "firstname should not be empty")
    private String firstname;

    @NotBlank(message = "lastname should not be empty")
    private String lastname;

    @NotBlank(message = "email should not be blank")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = "phoneNumber should not be blank")
    private String phoneNumber;

    @NotBlank(message = "password should not be blank")
    private String password;

}
