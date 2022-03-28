package com.bookstore.bookstore_javaspringboot_react_app.Service.impl;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Country;
import com.bookstore.bookstore_javaspringboot_react_app.Repository.CountryRepo;
import com.bookstore.bookstore_javaspringboot_react_app.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Country create(String name, String continent) {

        Country country = new Country(name, continent);

        return countryRepo.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepo.deleteById(id);
    }
}
