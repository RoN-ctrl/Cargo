package com.cargo.service;

import com.cargo.dto.CityDto;
import com.cargo.model.City;
import com.cargo.model.enums.Region;

import java.util.List;

public interface CityService {
    CityDto createCity(CityDto cityDto);

    CityDto getCityById(long id);

    CityDto getCityByName(String name);

    List<CityDto> getCitiesByRegion(Region region);

    CityDto updateCity(CityDto cityDto);

    void deleteCityById(long id);

    City mapCityDtoToCity(CityDto cityDto);

    CityDto mapCityToCityDto(City city);
}
