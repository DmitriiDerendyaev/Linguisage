package com.example.Imagenius.controller;

import com.example.Imagenius.entity.UserAnswer;
import com.example.Imagenius.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userAnswers")
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    @Autowired
    public UserAnswerController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @GetMapping("/{answerId}")
    public UserAnswer getUserAnswerById(@PathVariable Long answerId) {
        return userAnswerService.findById(answerId);
    }

    @GetMapping("/all")
    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerService.findAll();
    }

    @PostMapping("/add")
    public UserAnswer addUserAnswer(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.save(userAnswer);
    }

    @PutMapping("/update")
    public UserAnswer updateUserAnswer(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.update(userAnswer);
    }

    @DeleteMapping("/delete/{answerId}")
    public void deleteUserAnswer(@PathVariable Long answerId) {
        userAnswerService.delete(answerId);
    }
}
