package org.devops.bootcamp.utils;

import org.devops.bootcamp.repositories.BookRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

public class SellingReportGenerator implements IReportGenerator {

    private BookRepositoryImpl bookRepository;

    public SellingReportGenerator(BookRepositoryImpl repository) {
        bookRepository = repository;
    }

    public Map<String, String> generateReport() {
        return new HashMap<>();
    }
}
