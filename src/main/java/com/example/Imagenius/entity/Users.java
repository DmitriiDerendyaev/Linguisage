package com.example.Imagenius.entity;

import com.example.Imagenius.viewJSON.DefaultView;
import com.example.Imagenius.viewJSON.RegistrationView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonView(DefaultView.class)
    private Long userId;

    @Email(message = "Incorrect email")
    @NotNull(message = "Email cannot be empty")
    @Column(name = "email")
    @JsonView(RegistrationView.class)
    private String email;

    @NotNull(message = "Username cannot be empty")
    @Column(name = "username")
    @JsonView(RegistrationView.class)
    private String username;

    @Column(name = "password")
    @JsonView(RegistrationView.class)
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

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

    @PrePersist
    public void prePersist() {
        this.registeredAt = LocalDate.now();
    }
}
