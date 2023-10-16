package com.example.Imagenius.storage;

import com.example.Imagenius.entity.UserAnswer;
import com.example.Imagenius.repository.UserAnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerStorage extends AbstractStorage<UserAnswer, Long> {

    public UserAnswerStorage(UserAnswerRepository repository) {
        super(repository);
    }
}