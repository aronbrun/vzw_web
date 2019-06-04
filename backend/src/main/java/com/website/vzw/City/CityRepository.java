
package com.website.vzw.City;


import com.website.vzw.Address.Address;
import com.website.vzw.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
