package com.example.Imagenius.service;

import com.example.Imagenius.model.Word;
import com.example.Imagenius.model.WordImage;
import com.example.Imagenius.model.WordMeaning;
import com.example.Imagenius.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final WordImageService wordImageService;
    private final WordMeaningService wordMeaningService;
    @Autowired
    public WordService(WordRepository wordRepository, WordImageService wordImageService, WordMeaningService wordMeaningService) {
        this.wordRepository = wordRepository;
        this.wordImageService = wordImageService;
        this.wordMeaningService = wordMeaningService;
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public Word getWordById(Long id) {
        return wordRepository.findById(id).orElse(null);
    }

    public Word createWord(Word word) {
        // Сохраняем сущность Word
        Word savedWord = wordRepository.save(word);

        // Сохраняем связанные сущности WordImage
        if (word.getWordImages() != null) {
            for (WordImage wordImage : word.getWordImages()) {
                wordImage.setWord(savedWord);
                wordImageService.createWordImage(wordImage);
            }
        }

        // Сохраняем связанные сущности WordMeaning
        if (word.getWordMeanings() != null) {
            for (WordMeaning wordMeaning : word.getWordMeanings()) {
                wordMeaning.setWord(savedWord);
                wordMeaningService.createWordMeaning(wordMeaning);
            }
        }

        return savedWord;
    }

    public Word updateWord(Long id, Word updatedWord) {
        if (wordRepository.existsById(id)) {
            updatedWord.setWordId(id);
            return wordRepository.save(updatedWord);
        } else {
            return null; // Можно выбрасывать исключение, если запись не найдена
        }
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }
}

