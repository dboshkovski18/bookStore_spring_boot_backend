package com.bookstore.bookstore_javaspringboot_react_app.Service.impl;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Country;
import com.bookstore.bookstore_javaspringboot_react_app.Repository.AuthorRepo;
import com.bookstore.bookstore_javaspringboot_react_app.Repository.CountryRepo;
import com.bookstore.bookstore_javaspringboot_react_app.Service.AuthorService;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.AuthorDto;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final CountryRepo countryRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, CountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepo.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Author> create(AuthorDto authorDto) {

        Country country1 = countryRepo.getById(authorDto.getCountry());

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country1);

        return Optional.of(authorRepo.save(author));
    }

    @Override
    @Transactional
    public Optional<Author> edit(Long id, AuthorDto authorDto) {

        Country country1 = countryRepo.getById(authorDto.getCountry());
        Author author = authorRepo.getById(id);

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country1);

        return Optional.of(authorRepo.save(author));
    }

    @Override
    public void deleteById(Long id) {
        authorRepo.deleteById(id);
    }
}
