package com.example.Imagenius.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String passwordHash;

    @Column(name = "age")
    private Integer age;

    @Column(name = "batch_size")
    private Integer batchSize;

    @Column(name = "registered_at")
    private LocalDate registeredAt;

    @Column(name = "theme_mode")
    private String themeMode;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WordMeaning> wordMeanings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserLiterature> userLiteratures;
}
