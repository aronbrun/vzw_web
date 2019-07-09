package com.website.vzw.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.toIntExact;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Optional<Address> findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address;
    }

    public List<Address> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

    public boolean update(Address address, Long id) {
        Optional<Address> currentAddress = addressRepository.findById(id);
        if (currentAddress.isPresent()) {
            address.setIdAddress(toIntExact(id));
        } else {
            return false;
        }

        addressRepository.save(address);
        return true;
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

}
