package com.kefas.blogapplicationweeknine.repository;

import com.kefas.blogapplicationweeknine.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Page<Album> findByCreatedBy(Long id, Pageable pageable);
}
