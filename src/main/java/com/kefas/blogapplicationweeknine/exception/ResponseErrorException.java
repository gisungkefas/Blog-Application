package com.kefas.blogapplicationweeknine.exception;

import com.kefas.blogapplicationweeknine.response.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Setter
@Getter
public class ResponseErrorException extends RuntimeException{

    private transient ResponseEntity<ApiResponse> apiResponse;

    public ResponseErrorException(ResponseEntity<ApiResponse> apiResponse) {
        this.apiResponse = apiResponse;
    }
}
