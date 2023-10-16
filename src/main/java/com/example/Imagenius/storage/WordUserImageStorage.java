package com.example.Imagenius.storage;

import com.example.Imagenius.entity.WordUserImage;
import com.example.Imagenius.repository.WordUserImageRepository;
import org.springframework.stereotype.Service;

@Service
public class WordUserImageStorage extends AbstractStorage<WordUserImage, Long> {

    public WordUserImageStorage(WordUserImageRepository repository) {
        super(repository);
    }
}