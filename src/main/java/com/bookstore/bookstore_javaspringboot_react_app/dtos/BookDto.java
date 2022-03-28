package com.bookstore.bookstore_javaspringboot_react_app.dtos;

import com.bookstore.bookstore_javaspringboot_react_app.Enumerations.BookCategory;
import lombok.Data;
@Data
public class BookDto {

    private String name;

    private BookCategory category;

    private Long author;

    private Integer availableCopies;

    public BookDto(String name, BookCategory category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
