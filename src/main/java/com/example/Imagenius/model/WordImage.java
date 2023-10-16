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
@Table(name = "WordImage")
public class WordImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_image_id")
    private Long wordImageId;

    @ManyToOne
    @JoinColumn(name = "word_id")
    @JsonBackReference // Используйте @JsonBackReference, чтобы предотвратить циклическую зависимость
    private Word word;

    @Column(name = "image_path")
    private String imagePath;


}
