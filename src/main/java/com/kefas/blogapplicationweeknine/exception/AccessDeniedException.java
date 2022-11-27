package com.kefas.blogapplicationweeknine.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AccessDeniedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ApiResponse apiResponse;

    private String message;

    public AccessDeniedException(ApiResponse apiResponse){
        super();
        this.apiResponse = apiResponse;
    }

}
