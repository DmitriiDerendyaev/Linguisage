package com.example.Imagenius.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class UserLiterature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_literature_id")
    private Integer userLiteratureId;

    @Column(name = "content_id")
    private String contentId;

    @Column(name = "title")
    private String title;

    @Column(name = "add_datetime")
    private LocalDateTime addDateTime;

    @Column(name = "last_open_datetime")
    private LocalDateTime lastOpenDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
