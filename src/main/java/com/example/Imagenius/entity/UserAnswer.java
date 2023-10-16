package com.example.Imagenius.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_answer")
@Data
@RequiredArgsConstructor
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "word_meaning_id")
    private WordMeaning wordMeaning;

    @Column(name = "datetime")
    private LocalDate datetime;

    @Column(name = "isRight")
    private boolean isRight;

    @Column(name = "confidence")
    private double confidence;
}
