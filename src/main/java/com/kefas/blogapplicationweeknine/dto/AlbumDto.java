package com.kefas.blogapplicationweeknine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class AlbumDto {

    @NotBlank(message = "title should not be empty")
    private String title;
}
