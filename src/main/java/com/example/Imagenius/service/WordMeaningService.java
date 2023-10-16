package com.example.Imagenius.service;

import com.example.Imagenius.entity.WordMeaning;
import com.example.Imagenius.storage.WordMeaningStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordMeaningService {

    private final WordMeaningStorage wordMeaningStorage;

    public WordMeaningService(WordMeaningStorage wordMeaningStorage) {
        this.wordMeaningStorage = wordMeaningStorage;
    }

    public WordMeaning findById(Long wordMeaningId) {
        return wordMeaningStorage.findById(wordMeaningId);
    }

    public List<WordMeaning> findAll() {
        return wordMeaningStorage.findAll();
    }

    public WordMeaning save(WordMeaning wordMeaning) {
        return wordMeaningStorage.save(wordMeaning);
    }

    public WordMeaning update(WordMeaning wordMeaning) {
        return wordMeaningStorage.update(wordMeaning);
    }

    public void delete(Long wordMeaningId) {
        wordMeaningStorage.delete(wordMeaningId);
    }
}
