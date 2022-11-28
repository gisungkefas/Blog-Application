package com.kefas.blogapplicationweeknine.response;

import com.kefas.blogapplicationweeknine.model.User;
import lombok.Data;

@Data
public class AlbumResponse {

    private Long Id;

    private String tilte;

    private User user;

    private String photo;
}
