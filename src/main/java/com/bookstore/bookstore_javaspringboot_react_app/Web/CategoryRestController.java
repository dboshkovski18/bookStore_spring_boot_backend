package com.bookstore.bookstore_javaspringboot_react_app.Web;

import com.bookstore.bookstore_javaspringboot_react_app.Enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryRestController {

    private BookCategory bookCategory;

    @GetMapping
    List<BookCategory> findAllCategories(){
        List<BookCategory> bookCategories = Arrays.asList(BookCategory.values());
        return bookCategories;
    }
}
