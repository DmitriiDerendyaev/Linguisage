package com.example.Imagenius.service;

import com.example.Imagenius.entity.WordUserImage;
import com.example.Imagenius.storage.WordUserImageStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordUserImageService {

    private final WordUserImageStorage wordUserImageStorage;

    public WordUserImageService(WordUserImageStorage wordUserImageStorage) {
        this.wordUserImageStorage = wordUserImageStorage;
    }

    public WordUserImage findById(Long wordUserImageId) {
        return wordUserImageStorage.findById(wordUserImageId);
    }

    public List<WordUserImage> findAll() {
        return wordUserImageStorage.findAll();
    }

    public WordUserImage save(WordUserImage wordUserImage) {
        return wordUserImageStorage.save(wordUserImage);
    }

    public WordUserImage update(WordUserImage wordUserImage) {
        return wordUserImageStorage.update(wordUserImage);
    }

    public void delete(Long wordUserImageId) {
        wordUserImageStorage.delete(wordUserImageId);
    }
}
