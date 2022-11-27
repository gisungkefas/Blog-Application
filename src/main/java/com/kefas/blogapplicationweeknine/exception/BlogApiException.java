package com.kefas.blogapplicationweeknine.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class BlogApiException extends RuntimeException{

    private final HttpStatus status;

    private final String message;

    public BlogApiException(HttpStatus status, String message, Throwable exception) {
        super(exception);
        this.status = status;
        this.message = message;
    }
}
