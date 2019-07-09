package com.website.vzw.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);

        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Address>> getAll() {
        List<Address> addresses = addressService.findAll();

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
        addressService.save(address);

        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateById(@PathVariable Long id, @Valid @RequestBody Address address) {
        HttpStatus status = ((addressService.update(address, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(address, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}