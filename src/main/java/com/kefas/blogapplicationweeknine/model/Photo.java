package com.kefas.blogapplicationweeknine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    private String thumbnailUrl;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;
}
