package com.bookstore.bookstore_javaspringboot_react_app.Service;

import com.bookstore.bookstore_javaspringboot_react_app.Enumerations.BookCategory;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Book;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> create(BookDto bookDto);

    Optional<Book> edit(Long id,BookDto bookDto);

    void deleteById(Long id);

    void rentABook(Long id);
}
