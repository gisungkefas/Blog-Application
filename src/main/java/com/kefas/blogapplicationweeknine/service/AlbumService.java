package com.kefas.blogapplicationweeknine.service;

import com.kefas.blogapplicationweeknine.model.Album;
import com.kefas.blogapplicationweeknine.payload.AlbumPayload;
import com.kefas.blogapplicationweeknine.response.AlbumResponse;
import com.kefas.blogapplicationweeknine.response.ApiResponse;
import com.kefas.blogapplicationweeknine.response.PagedResponse;
import org.springframework.http.ResponseEntity;

import java.nio.file.attribute.UserPrincipal;

public interface AlbumService {

    PagedResponse<AlbumResponse> getAllAlbums(int page, int size);
    ResponseEntity<Album> addAlbum(AlbumPayload albumRequest, UserPrincipal currentUser);
    ResponseEntity<Album> getAlbum(long id);
    ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumPayload newAlbum, UserPrincipal currentUser);
    PagedResponse<Album> getUserAlbums(String email, int page, int size);
}
