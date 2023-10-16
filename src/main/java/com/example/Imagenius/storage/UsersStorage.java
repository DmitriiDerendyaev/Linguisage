package com.example.Imagenius.storage;

import com.example.Imagenius.entity.Users;
import com.example.Imagenius.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersStorage extends AbstractStorage<Users, Long> {

    public UsersStorage(UsersRepository repository) {
        super(repository);
    }
}
