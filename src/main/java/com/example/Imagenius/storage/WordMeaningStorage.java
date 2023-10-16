package com.example.Imagenius.storage;

import com.example.Imagenius.entity.WordMeaning;
import com.example.Imagenius.repository.WordMeaningRepository;
import org.springframework.stereotype.Service;

@Service
public class WordMeaningStorage extends AbstractStorage<WordMeaning, Long> {

    public WordMeaningStorage(WordMeaningRepository repository) {
        super(repository);
    }
}