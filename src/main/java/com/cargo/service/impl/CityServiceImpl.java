package com.cargo.service.impl;

import com.cargo.dto.CityDto;
import com.cargo.model.City;
import com.cargo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImpl {

    CityRepository cityRepository;

    public CityDto createCity(CityDto cityDto) {
        City city = mapCityDtoToCity(cityDto);
        city = cityRepository.save(city);
        log.info("creating city={}", city);
        return mapCityToCityDto(city);
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
