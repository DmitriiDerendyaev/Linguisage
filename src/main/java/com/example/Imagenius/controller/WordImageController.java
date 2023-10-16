package com.example.Imagenius.controller;

import com.example.Imagenius.model.WordImage;
import com.example.Imagenius.service.WordImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word-images")
public class WordImageController {

    private final WordImageService wordImageService;

    @Autowired
    public WordImageController(WordImageService wordImageService) {
        this.wordImageService = wordImageService;
    }

    @GetMapping("/")
    public List<WordImage> getAllWordImages() {
        return wordImageService.getAllWordImages();
    }

    @GetMapping("/{id}")
    public WordImage getWordImageById(@PathVariable Long id) {
        return wordImageService.getWordImageById(id);
    }

    @PostMapping("/")
    public WordImage createWordImage(@RequestBody WordImage wordImage) {
        return wordImageService.createWordImage(wordImage);
    }

    @PutMapping("/{id}")
    public WordImage updateWordImage(@PathVariable Long id, @RequestBody WordImage updatedWordImage) {
        return wordImageService.updateWordImage(id, updatedWordImage);
    }

    @DeleteMapping("/{id}")
    public void deleteWordImage(@PathVariable Long id) {
        wordImageService.deleteWordImage(id);
    }
}
