package com.website.vzw.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.toIntExact;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Optional<City> findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city;
    }

    public List<City> findAll() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public boolean update(City city, Long id) {
        Optional<City> currentCity = cityRepository.findById(id);
        if (currentCity.isPresent()) {
            city.setIdCity(toIntExact(id));
        } else {
            return false;
        }

        cityRepository.save(city);
        return true;
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

}
