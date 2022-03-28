package com.bookstore.bookstore_javaspringboot_react_app.config;

import com.bookstore.bookstore_javaspringboot_react_app.Enumerations.BookCategory;
import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Service.AuthorService;
import com.bookstore.bookstore_javaspringboot_react_app.Service.BookService;
import com.bookstore.bookstore_javaspringboot_react_app.Service.CountryService;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.AuthorDto;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.BookDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {


    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData(){

        //INITIALIZE COUNTRIES
        countryService.create("Macedonia","Europe");
        countryService.create("Serbia","Europe");
        countryService.create("Germany","Europe");
        countryService.create("Italy","Europe");
        countryService.create("Chicago","USA");
        countryService.create("Washington","USA");

        //INITIALIZE AUTHORS
        authorService.create(new AuthorDto("Blaze","Koneski",1L));
        authorService.create(new AuthorDto("Sergej","Sergejovic",2L));
        authorService.create(new AuthorDto("Adam","Willy",5L));
        authorService.create(new AuthorDto("Francesco","Palenta",4L));
        authorService.create(new AuthorDto("Robin","Shweiz",3L));

        //INITIALIZE BOOKS
        bookService.create(new BookDto("Pirej", BookCategory.DRAMA,1L,10));
        bookService.create(new BookDto("Tajnu", BookCategory.BIOGRAPHY,2L,10));
        bookService.create(new BookDto("Fratelli", BookCategory.THRILER,4L,10));
        bookService.create(new BookDto("Hitler", BookCategory.NOVEL,3L,10));
        bookService.create(new BookDto("Walk away", BookCategory.CLASSICS,5L,10));
        bookService.create(new BookDto("Pirej 2", BookCategory.DRAMA,1L,10));
        bookService.create(new BookDto("Tajnu 2", BookCategory.BIOGRAPHY,2L,10));
        bookService.create(new BookDto("Fratelli 2", BookCategory.THRILER,4L,10));
        bookService.create(new BookDto("Hitler 2", BookCategory.NOVEL,3L,10));
        bookService.create(new BookDto("Walk away 2", BookCategory.CLASSICS,5L,10));



    }


}
