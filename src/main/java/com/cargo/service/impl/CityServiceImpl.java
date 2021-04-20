package com.cargo.service.impl;

import com.cargo.dto.CityDto;
import com.cargo.exceptions.NoSuchAccountFoundException;
import com.cargo.exceptions.NoSuchCityFoundException;
import com.cargo.model.City;
import com.cargo.model.enums.Region;
import com.cargo.repository.CityRepository;
import com.cargo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityDto createCity(CityDto cityDto) {
        City city = mapCityDtoToCity(cityDto);
        city = cityRepository.save(city);
        log.info("creating city={}", city);
        return mapCityToCityDto(city);
    }

    @Override
    public CityDto getCityById(long id) {
        log.info("getting city by id={}", id);
        return mapCityToCityDto(cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchCityFoundException("No city with such ID found")));
    }

    @Override
    public CityDto getCityByName(String name) {
        log.info("getting city by name={}", name);
        return mapCityToCityDto(cityRepository.findByName(name)
                .orElseThrow(() -> new NoSuchCityFoundException("No city with such NAME found")));
    }

    @Override
    public List<CityDto> getCitiesByRegion(Region region) {
        log.info("getting cities by region={}", region);
        Sort sortByName = Sort.by("name");
        List<City> cities = cityRepository.findAllByRegion(region, sortByName);
        List<CityDto> cityDtos = new ArrayList<>();

        for (City city : cities) {
            cityDtos.add(mapCityToCityDto(city));
        }

        return cityDtos;
    }

    @Override
    public CityDto updateCity(CityDto cityDto) {
        cityRepository.delete(cityRepository.findByName(cityDto.getName())
                .orElseThrow(NoSuchAccountFoundException::new));
        City city = mapCityDtoToCity(cityDto);
        city = cityRepository.save(city);
        log.info("updating city={}", city);
        return mapCityToCityDto(city);
    }

    @Override
    public void deleteCityById(long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccountFoundException("No city with such ID found"));
        log.info("deleting city={}", city);
        cityRepository.delete(city);
    }

    private City mapCityDtoToCity(CityDto cityDto) {
        return City.builder()
                .name(cityDto.getName())
                .region(cityDto.getRegion())
                .latitude(cityDto.getLatitude())
                .longitude(cityDto.getLongitude())
                .build();
    }

    private CityDto mapCityToCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .region(city.getRegion())
                .latitude(city.getLatitude())
                .longitude(city.getLongitude())
                .build();
    }

}
