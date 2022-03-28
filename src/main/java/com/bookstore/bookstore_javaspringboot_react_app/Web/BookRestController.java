package com.bookstore.bookstore_javaspringboot_react_app.Web;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Book;
import com.bookstore.bookstore_javaspringboot_react_app.Service.BookService;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "https://bookstore-react-frontend2.herokuapp.com")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    //todo READ
    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //todo DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    //todo CREATE
    @PostMapping("/add")
    public ResponseEntity<Book> create(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //todo EDIT
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,
                                     @RequestBody BookDto bookDto) {
        return bookService.edit(id,bookDto).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/rent/{id}")
    public void rentABook(@PathVariable Long id) {
        bookService.rentABook(id);
    }
}
