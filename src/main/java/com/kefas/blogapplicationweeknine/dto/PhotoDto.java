package com.kefas.blogapplicationweeknine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class PhotoDto {

    @NotBlank(message = "title should not be blank")
    private String title;

    @NotBlank(message = "url should not be blank")
    private String url;

    @NotBlank(message = "thumbnailUrl should not be blank")
    private String thumbnailUrl;

}
