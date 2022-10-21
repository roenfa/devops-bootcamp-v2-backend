package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Book;

import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public <S extends Book> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findByAuthor(String author) {
        return Optional.empty();
    }
}