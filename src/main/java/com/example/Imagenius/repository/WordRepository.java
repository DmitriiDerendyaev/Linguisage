package com.example.Imagenius.repository;

import com.example.Imagenius.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    // Дополнительные методы для работы с сущностью Word, если необходимо
}