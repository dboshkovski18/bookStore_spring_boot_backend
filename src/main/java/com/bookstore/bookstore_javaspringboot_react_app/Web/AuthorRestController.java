package com.bookstore.bookstore_javaspringboot_react_app.Web;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import com.bookstore.bookstore_javaspringboot_react_app.Service.AuthorService;
import com.bookstore.bookstore_javaspringboot_react_app.dtos.AuthorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "https://bookstore-react-frontend2.herokuapp.com")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //todo READ

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return authorService.findById(id).map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //todo CREATE
    @PostMapping("/add")
    public ResponseEntity<Author> create(@RequestBody AuthorDto authorDto){
        return authorService.create(authorDto).map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    //todo EDIT
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id,@RequestBody AuthorDto authorDto){
        return authorService.edit(id,authorDto).map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //todo DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        authorService.deleteById(id);
    }


}
