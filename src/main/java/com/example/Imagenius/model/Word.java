package com.example.Imagenius.model;

import com.example.Imagenius.model.WordImage;
import com.example.Imagenius.model.WordMeaning;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long wordId;

    @Column(name = "word_content")
    private String wordContent;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("word")
    private List<WordImage> wordImages;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("word")
    private List<WordMeaning> wordMeanings;
}
