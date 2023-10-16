package com.example.Imagenius.repository;

import com.example.Imagenius.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByEmail(String email);
}