package com.kefas.blogapplicationweeknine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class CommentDto {

    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "email should not be empty")
    private String email;

    @NotBlank(message = "comment body should not be empty")
    private String body;
}
