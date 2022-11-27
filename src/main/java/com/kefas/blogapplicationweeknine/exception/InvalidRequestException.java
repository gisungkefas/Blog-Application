package com.kefas.blogapplicationweeknine.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Data
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidRequestException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private final String tokenType;

    private String token;

    private final String message;

    public InvalidRequestException(String tokenType, String token, String message) {
        super(String.format("%s: [%s} token: [%s] ", message, tokenType, token));
        this.tokenType = tokenType;
        this.token = token;
        this.message = message;
    }
}
