package com.bookstore.bookstore_javaspringboot_react_app.Service.impl;

import com.bookstore.bookstore_javaspringboot_react_app.Enumerations.BookCategory;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Book;
import com.bookstore.bookstore_javaspringboot_react_app.Repository.AuthorRepo;
import com.bookstore.bookstore_javaspringboot_react_app.Repository.BookRepo;
import com.bookstore.bookstore_javaspringboot_react_app.Service.BookService;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.BookDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookServiceImpl(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Book> create(BookDto bookDto) {

        Author author1= authorRepo.getById(bookDto.getAuthor());

        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author1,bookDto.getAvailableCopies());

        return Optional.of(bookRepo.save(book));
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id,BookDto bookDto) {

        Author author1= authorRepo.getById(bookDto.getAuthor());
        Book book = bookRepo.getById(id);

        book.setAuthor(author1);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setName(bookDto.getName());

        return Optional.of(bookRepo.save(book));
    }


    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void rentABook(Long id) {
        Book book = bookRepo.getById(id);

        Integer copies = book.getAvailableCopies();

        book.setAvailableCopies(copies-1);

        bookRepo.save(book);
    }
}
