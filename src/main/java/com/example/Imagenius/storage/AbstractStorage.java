package com.example.Imagenius.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractStorage<T, ID> {

    private final JpaRepository<T, ID> repository;

    public AbstractStorage(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T findById(ID id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}
