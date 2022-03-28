package com.bookstore.bookstore_javaspringboot_react_app.Repository;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {


}
