//package com.cargo.repository.impl;
//
//import com.cargo.model.City;
//import com.cargo.model.enums.Region;
//import com.cargo.exceptions.NoSuchCityFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//public class CityRepositoryImpl {
//
//    private final List<City> cities = new ArrayList<>();
//
//    public City createCity(City city) {
//        cities.add(city);
//        return city;
//    }
//
//    public City getCityById(long id) {
//        return cities.stream()
//                .filter(c -> c.getId() == id)
//                .findAny()
//                .orElseThrow(NoSuchCityFoundException::new);
//    }
//
//    public City getCityByName(String cityName) {
//        return cities.stream()
//                .filter(c -> c.getName().equals(cityName))
//                .findAny()
//                .orElseThrow(NoSuchCityFoundException::new);
//    }
//
//    public List<City> getCitiesByRegion(Region region) {
//        return cities.stream()
//                .filter(c -> c.getRegion().equals(region))
//                .collect(Collectors.toList());
//    }
//
//
//
//}
