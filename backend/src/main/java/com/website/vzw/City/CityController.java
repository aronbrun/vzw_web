package com.website.vzw.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Cities")
public class CityController {

    @Autowired
    private CityService cityService;


    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);

        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityService.findAll();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<City> create(@Valid @RequestBody City city) {
        cityService.save(city);

        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateById(@PathVariable Long id, @Valid @RequestBody City city) {
        HttpStatus status = ((cityService.update(city, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(city, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cityService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}