package com.example.Imagenius.service;

import com.example.Imagenius.model.WordImage;
import com.example.Imagenius.repository.WordImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordImageService {

    private final WordImageRepository wordImageRepository;

    @Autowired
    public WordImageService(WordImageRepository wordImageRepository) {
        this.wordImageRepository = wordImageRepository;
    }

    public List<WordImage> getAllWordImages() {
        return wordImageRepository.findAll();
    }

    public WordImage getWordImageById(Long id) {
        return wordImageRepository.findById(id).orElse(null);
    }

    public WordImage createWordImage(WordImage wordImage) {
        return wordImageRepository.save(wordImage);
    }

    public WordImage updateWordImage(Long id, WordImage updatedWordImage) {
        if (wordImageRepository.existsById(id)) {
            updatedWordImage.setWordImageId(id);
            return wordImageRepository.save(updatedWordImage);
        } else {
            return null; // Можно выбрасывать исключение, если запись не найдена
        }
    }

    public void deleteWordImage(Long id) {
        wordImageRepository.deleteById(id);
    }
}
