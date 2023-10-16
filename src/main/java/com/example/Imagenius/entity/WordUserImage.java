package com.example.Imagenius.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "word_user_image")
@Data
@RequiredArgsConstructor
public class WordUserImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_user_image_id")
    private Long wordUserImageId;

    @ManyToOne
    @JoinColumn(name = "word_meaning_id")
    private WordMeaning wordMeaning;

    @Column(name = "content")
    private String content;
}
