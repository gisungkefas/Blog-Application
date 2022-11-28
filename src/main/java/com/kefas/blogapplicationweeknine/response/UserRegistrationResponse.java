package com.kefas.blogapplicationweeknine.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserRegistrationResponse {

    private String message;

    private LocalDateTime timeStamp;
}
