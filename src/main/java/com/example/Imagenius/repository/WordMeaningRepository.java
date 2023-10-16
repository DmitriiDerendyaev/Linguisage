package com.example.Imagenius.repository;

import com.example.Imagenius.entity.WordMeaning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordMeaningRepository extends JpaRepository<WordMeaning, Long> {
}