package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Book;

import java.util.Optional;

public interface BookRepository extends BasicRepository<Book, Long> {
    Optional<Book> findByAuthor(String author);
}
