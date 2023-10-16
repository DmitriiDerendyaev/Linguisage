package com.example.Imagenius.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WordMeaning")
public class WordMeaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_meaning_id")
    private Long wordMeaningId;

    @ManyToOne
    @JoinColumn(name = "word_id")
    @JsonBackReference // Используйте @JsonBackReference, чтобы предотвратить циклическую зависимость
    private Word word;

    @Column(name = "word_meaning")
    private String wordMeaning;
}
