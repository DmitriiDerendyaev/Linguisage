package com.example.Imagenius.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "word_meaning")
@Data
@RequiredArgsConstructor
public class WordMeaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_meaning_id")
    private Long wordMeaningId;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "source")
    private String source;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "wordMeaning", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "wordMeaning", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WordUserImage> wordUserImages;
}
