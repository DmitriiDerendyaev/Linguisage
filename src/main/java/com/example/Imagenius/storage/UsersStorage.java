package com.example.Imagenius.storage;

import com.example.Imagenius.entity.Users;
import com.example.Imagenius.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersStorage extends AbstractStorage<Users, Long> {

    @Autowired
    public UsersRepository usersRepository;
    public UsersStorage(UsersRepository repository) {
        super(repository);
    }

    public Optional<Users> findByEmail(String email) {

        return usersRepository.findByEmail(email);
    }
}
