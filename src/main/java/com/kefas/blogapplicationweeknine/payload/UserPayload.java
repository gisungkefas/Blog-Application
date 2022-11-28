package com.kefas.blogapplicationweeknine.payload;

import com.kefas.blogapplicationweeknine.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPayload {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String phone;

    private String website;

    public User getUserFromPayload() {
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setPassword(password);


        return new User();
    }
}
