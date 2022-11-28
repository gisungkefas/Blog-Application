package com.kefas.blogapplicationweeknine.service;

import com.kefas.blogapplicationweeknine.payload.PhotoPayload;
import com.kefas.blogapplicationweeknine.response.PagedResponse;
import com.kefas.blogapplicationweeknine.response.PhotoResponse;

import java.nio.file.attribute.UserPrincipal;

public interface PhotoService {

    PagedResponse<PhotoResponse> getAllPhoto(int page, int size);
    PhotoResponse getPhoto(Long id);
    PhotoResponse updatePhoto(Long id, PhotoPayload photoPayload, UserPrincipal currentUser);
    PhotoResponse addPhoto(PhotoPayload photoPayload, UserPrincipal currentUser);
    PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);
}
