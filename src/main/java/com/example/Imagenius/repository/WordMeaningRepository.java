package com.example.Imagenius.repository;

import com.example.Imagenius.model.WordMeaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordMeaningRepository extends JpaRepository<WordMeaning, Long> {
    // Дополнительные методы для работы с сущностью WordMeaning, если необходимо
}