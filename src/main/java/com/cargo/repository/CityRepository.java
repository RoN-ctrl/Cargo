package com.cargo.repository;

import com.cargo.model.City;
import com.cargo.model.enums.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);

    List<City> findAllByRegion(Region region, Sort sort);
}
