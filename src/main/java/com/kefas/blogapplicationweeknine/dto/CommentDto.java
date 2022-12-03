package com.kefas.blogapplicationweeknine.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CommentDto {

	@NotBlank(message = "Comment body cannot be blank")
	private String content;

	@NotNull
	private Long userId;
}
