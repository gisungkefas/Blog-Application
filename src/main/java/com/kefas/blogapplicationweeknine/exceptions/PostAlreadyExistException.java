package com.kefas.blogapplicationweeknine.exceptions;

public class PostAlreadyExistException extends RuntimeException{
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
