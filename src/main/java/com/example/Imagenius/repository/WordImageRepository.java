package com.example.Imagenius.repository;

import com.example.Imagenius.model.WordImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordImageRepository extends JpaRepository<WordImage, Long> {
    // Дополнительные методы для работы с сущностью WordImage, если необходимо
}
