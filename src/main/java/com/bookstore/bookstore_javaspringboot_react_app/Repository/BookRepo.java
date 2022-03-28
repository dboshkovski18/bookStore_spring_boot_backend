package com.bookstore.bookstore_javaspringboot_react_app.Repository;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
