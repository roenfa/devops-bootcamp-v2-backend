package org.devops.bootcamp.services;

import lombok.AllArgsConstructor;
import org.devops.bootcamp.models.Book;
import org.devops.bootcamp.repositories.BookRepository;
import org.devops.bootcamp.repositories.BookRepositoryImpl;
import org.devops.bootcamp.utils.INumberGenerator;
import org.devops.bootcamp.utils.IReportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private INumberGenerator generator;

//    @Autowired
//    private IReportGenerator reportGenerator;

//    public BookService(INumberGenerator generator, BookRepositoryImpl repo, IReportGenerator reportGenerator) {
//        this.generator = generator;
//        this.bookRepository = repo;
//        this.reportGenerator = reportGenerator;
//    }

    public Book sellBook(String author, String title, String location) {
        String number = generator.generateNumber();
        return bookRepository.save(new Book(title, author, number));
    }

    public String reportSellsByAuthor() {
        // ...
        return "";
    }
}