package com.example.Imagenius.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "word_meaning")
@Data
@RequiredArgsConstructor
public class WordMeaning {

    @Id
    @Column(name = "word_meaning_id")
    private Long wordMeaningId;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "wordMeaning", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "wordMeaning", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WordUserImage> wordUserImages;
}