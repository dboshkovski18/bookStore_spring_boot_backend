package com.bookstore.bookstore_javaspringboot_react_app.Service;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> create(AuthorDto authorDto);

    Optional<Author> edit(Long id,AuthorDto authorDto);

    void deleteById(Long id);

}
