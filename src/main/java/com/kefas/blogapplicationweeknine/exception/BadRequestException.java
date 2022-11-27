package com.kefas.blogapplicationweeknine.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ApiResponse apiResponse;

    public BadRequestException(ApiResponse apiResponse){
        super();
        this.apiResponse = apiResponse;
    }


}
