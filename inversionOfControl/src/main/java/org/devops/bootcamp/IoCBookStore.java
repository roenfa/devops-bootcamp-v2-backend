package org.devops.bootcamp;

import org.devops.bootcamp.repositories.BookRepositoryImpl;
import org.devops.bootcamp.services.BookService;
import org.devops.bootcamp.utils.INumberGenerator;
import org.devops.bootcamp.utils.SellingReportGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCBookStore {
    public static void main(String [] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        var service = context.getBean("getBookService", BookService.class);
        service.sellBook("Robert C Martin", "Clean Code", "BO");
//        IoCBookStore container = new IoCBookStore();

//        INumberGenerator generator = new GeneratorNumberFactory().getInstance("BO");
//
//        BookService service = new BookService(
//                generator,
//                new BookRepositoryImpl(),
//                new SellingReportGenerator(new BookRepositoryImpl())
//        );
//
//        service.sellBook("Robert C Martin", "Clean Code", "BO");
    }
}
