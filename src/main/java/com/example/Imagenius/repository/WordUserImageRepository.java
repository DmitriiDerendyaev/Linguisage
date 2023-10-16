package com.example.Imagenius.repository;

import com.example.Imagenius.entity.WordUserImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordUserImageRepository extends JpaRepository<WordUserImage, Long> {
}