package com.example.Imagenius.controller;

import com.example.Imagenius.entity.WordMeaning;
import com.example.Imagenius.service.WordMeaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wordMeanings")
public class WordMeaningController {

    private final WordMeaningService wordMeaningService;

    @Autowired
    public WordMeaningController(WordMeaningService wordMeaningService) {
        this.wordMeaningService = wordMeaningService;
    }

    @GetMapping("/{wordMeaningId}")
    public WordMeaning getWordMeaningById(@PathVariable Long wordMeaningId) {
        return wordMeaningService.findById(wordMeaningId);
    }

    @GetMapping("/all")
    public List<WordMeaning> getAllWordMeanings() {
        return wordMeaningService.findAll();
    }

    @PostMapping("/add")
    public WordMeaning addWordMeaning(@RequestBody WordMeaning wordMeaning) {
        return wordMeaningService.save(wordMeaning);
    }

    @PutMapping("/update")
    public WordMeaning updateWordMeaning(@RequestBody WordMeaning wordMeaning) {
        return wordMeaningService.update(wordMeaning);
    }

    @DeleteMapping("/delete/{wordMeaningId}")
    public void deleteWordMeaning(@PathVariable Long wordMeaningId) {
        wordMeaningService.delete(wordMeaningId);
    }
}
