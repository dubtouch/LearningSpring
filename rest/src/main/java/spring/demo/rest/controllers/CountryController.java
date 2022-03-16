package spring.demo.rest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.rest.models.Country;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country france = Country.of("france", 67);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(france);
    }

    @GetMapping("/all")
    public List<Country> all() {
        return List.of(Country.of("france", 67), Country.of("spain", 47));
    }
}
