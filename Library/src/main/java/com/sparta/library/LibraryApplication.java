package com.sparta.library;

import com.sparta.library.entities.Author;
import com.sparta.library.entities.Book;
import com.sparta.library.repositories.AuthorRepository;
import com.sparta.library.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);


        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        for(Author author: authorRepository.findAll()){
            System.out.println(author.getFullName());
        }

        for(Book book : bookRepository.findAll()){
            System.out.println(book.getTitle() + " by: " + book.getAuthor().getFullName());
        }

        for(Book book : bookRepository.findByTitleContainingIgnoreCase("LO")){
            System.out.println(book.getTitle() + " by: " + book.getAuthor().getFullName());
        }
    }

}
