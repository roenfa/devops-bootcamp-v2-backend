package org.devops.bootcamp.config;

import org.devops.bootcamp.models.Book;
import org.devops.bootcamp.repositories.BookRepository;
import org.devops.bootcamp.repositories.BookRepositoryImpl;
import org.devops.bootcamp.services.BookService;
import org.devops.bootcamp.utils.INumberGenerator;
import org.devops.bootcamp.utils.LocalSerialGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean(name = "LocalNumberGenerator")
    public INumberGenerator getLocalNumberGenerator() {
        INumberGenerator generator = new LocalSerialGenerator();
        return generator;
    }

    @Bean(name = "getLocalNumber")
    public String getLocalNumber() {
        INumberGenerator generator = new LocalSerialGenerator();
        return generator.generateNumber();
    }

    @Bean(name="initializeBookRepo")
    public BookRepository initializeBookRepository() {
        BookRepository repo = new BookRepositoryImpl();
        repo.save(new Book("Robert C Martin", "Clean Code", this.getLocalNumber()));

        return repo;
    }

    @Bean(name = "getBookService")
    public BookService getBookService() {
        BookService s = new BookService(this.initializeBookRepository(), this.getLocalNumberGenerator());
        return s;
    }
}
