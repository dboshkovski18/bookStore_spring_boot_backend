package com.bookstore.bookstore_javaspringboot_react_app.Web;

import com.bookstore.bookstore_javaspringboot_react_app.Model.Country;
import com.bookstore.bookstore_javaspringboot_react_app.Service.CountryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "https://bookstore-react-frontend2.herokuapp.com")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return countryService.findById(id).map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
