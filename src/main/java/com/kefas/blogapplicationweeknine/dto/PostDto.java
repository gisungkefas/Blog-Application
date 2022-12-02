package com.kefas.blogapplicationweeknine.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	@NotBlank(message = "Title should not be empty")
	private String title;

	@NotBlank(message = "Post body cannot be empty")
	private String content;

	@NotBlank(message = "Image URL should not be epmpty")
	private String imageUrl;
	
	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;

	@NotNull
	private Long userId;

}
