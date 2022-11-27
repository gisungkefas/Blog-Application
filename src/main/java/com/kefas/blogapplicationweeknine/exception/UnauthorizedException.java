package com.kefas.blogapplicationweeknine.exception;

import com.kefas.blogapplicationweeknine.response.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{

    private ApiResponse apiResponse;

    private String message;

    public UnauthorizedException(ApiResponse apiResponse) {
        super();
        this.apiResponse = apiResponse;
    }

    public UnauthorizedException(String message) {
        super();
        this.message = message;
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
