package com.example.Imagenius.service;

import com.example.Imagenius.entity.UserAnswer;
import com.example.Imagenius.storage.UserAnswerStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    
public class UserAnswerService {

    private final UserAnswerStorage userAnswerStorage;

    public UserAnswerService(UserAnswerStorage userAnswerStorage) {
        this.userAnswerStorage = userAnswerStorage;
    }

    public UserAnswer findById(Long answerId) {
        return userAnswerStorage.findById(answerId);
    }

    public List<UserAnswer> findAll() {
        return userAnswerStorage.findAll();
    }

    public UserAnswer save(UserAnswer userAnswer) {
        return userAnswerStorage.save(userAnswer);
    }

    public UserAnswer update(UserAnswer userAnswer) {
        return userAnswerStorage.update(userAnswer);
    }

    public void delete(Long answerId) {
        userAnswerStorage.delete(answerId);
    }
}
