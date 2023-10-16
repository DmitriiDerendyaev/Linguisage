package com.example.Imagenius.controller;

import com.example.Imagenius.model.WordMeaning;
import com.example.Imagenius.service.WordMeaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word-meanings")
public class WordMeaningController {

    private final WordMeaningService wordMeaningService;

    @Autowired
    public WordMeaningController(WordMeaningService wordMeaningService) {
        this.wordMeaningService = wordMeaningService;
    }

    @GetMapping("/")
    public List<WordMeaning> getAllWordMeanings() {
        return wordMeaningService.getAllWordMeanings();
    }

    @GetMapping("/{id}")
    public WordMeaning getWordMeaningById(@PathVariable Long id) {
        return wordMeaningService.getWordMeaningById(id);
    }

    @PostMapping("/")
    public WordMeaning createWordMeaning(@RequestBody WordMeaning wordMeaning) {
        return wordMeaningService.createWordMeaning(wordMeaning);
    }

    @PutMapping("/{id}")
    public WordMeaning updateWordMeaning(@PathVariable Long id, @RequestBody WordMeaning updatedWordMeaning) {
        return wordMeaningService.updateWordMeaning(id, updatedWordMeaning);
    }

    @DeleteMapping("/{id}")
    public void deleteWordMeaning(@PathVariable Long id) {
        wordMeaningService.deleteWordMeaning(id);
    }
}

