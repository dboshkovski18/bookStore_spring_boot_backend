package com.bookstore.bookstore_javaspringboot_react_app.Service;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country create(String name, String continent);

    void deleteById(Long id);
}
