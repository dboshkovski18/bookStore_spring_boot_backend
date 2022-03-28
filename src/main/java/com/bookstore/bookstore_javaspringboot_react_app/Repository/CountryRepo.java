package com.bookstore.bookstore_javaspringboot_react_app.Repository;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {


}
