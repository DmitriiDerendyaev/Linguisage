package com.example.Imagenius.controller;

import com.example.Imagenius.entity.WordUserImage;
import com.example.Imagenius.service.WordUserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wordUserImages")
public class WordUserImageController {

    private final WordUserImageService wordUserImageService;

    @Autowired
    public WordUserImageController(WordUserImageService wordUserImageService) {
        this.wordUserImageService = wordUserImageService;
    }

    @GetMapping("/{wordUserImageId}")
    public WordUserImage getWordUserImageById(@PathVariable Long wordUserImageId) {
        return wordUserImageService.findById(wordUserImageId);
    }

    @GetMapping("/all")
    public List<WordUserImage> getAllWordUserImages() {
        return wordUserImageService.findAll();
    }

    @PostMapping("/add")
    public WordUserImage addWordUserImage(@RequestBody WordUserImage wordUserImage) {
        return wordUserImageService.save(wordUserImage);
    }

    @PutMapping("/update")
    public WordUserImage updateWordUserImage(@RequestBody WordUserImage wordUserImage) {
        return wordUserImageService.update(wordUserImage);
    }

    @DeleteMapping("/delete/{wordUserImageId}")
    public void deleteWordUserImage(@PathVariable Long wordUserImageId) {
        wordUserImageService.delete(wordUserImageId);
    }
}
