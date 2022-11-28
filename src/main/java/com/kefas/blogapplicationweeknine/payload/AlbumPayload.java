package com.kefas.blogapplicationweeknine.payload;

import com.kefas.blogapplicationweeknine.model.User;
import lombok.Data;

@Data
public class AlbumPayload{

    private Long id;

    private String title;

    private User user;

    private String photo;
}
