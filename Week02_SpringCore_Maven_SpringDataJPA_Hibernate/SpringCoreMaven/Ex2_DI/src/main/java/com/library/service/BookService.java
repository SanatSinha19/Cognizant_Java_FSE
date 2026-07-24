package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showServiceStatus() {
        System.out.println("BookService is up and running.");
    }

    public void getBookDetails(int id) {
        String result = bookRepository.findBookById(id);
        System.out.println("Fetched from repository: " + result);
    }
}