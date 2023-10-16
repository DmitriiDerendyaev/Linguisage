package com.example.Imagenius.service;

import com.example.Imagenius.model.WordMeaning;
import com.example.Imagenius.repository.WordMeaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordMeaningService {

    private final WordMeaningRepository wordMeaningRepository;

    @Autowired
    public WordMeaningService(WordMeaningRepository wordMeaningRepository) {
        this.wordMeaningRepository = wordMeaningRepository;
    }

    public List<WordMeaning> getAllWordMeanings() {
        return wordMeaningRepository.findAll();
    }

    public WordMeaning getWordMeaningById(Long id) {
        return wordMeaningRepository.findById(id).orElse(null);
    }

    public WordMeaning createWordMeaning(WordMeaning wordMeaning) {
        return wordMeaningRepository.save(wordMeaning);
    }

    public WordMeaning updateWordMeaning(Long id, WordMeaning updatedWordMeaning) {
        if (wordMeaningRepository.existsById(id)) {
            updatedWordMeaning.setWordMeaningId(id);
            return wordMeaningRepository.save(updatedWordMeaning);
        } else {
            return null; // Можно выбрасывать исключение, если запись не найдена
        }
    }

    public void deleteWordMeaning(Long id) {
        wordMeaningRepository.deleteById(id);
    }
}
