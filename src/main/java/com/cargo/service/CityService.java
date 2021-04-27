package com.cargo.service;

import com.cargo.dto.CityDto;
import com.cargo.model.City;
import com.cargo.model.enums.Region;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface CityService {
    CityDto createCity(CityDto cityDto);

    CityDto getCityById(long id);

    CityDto getCityByName(String name);

    List<CityDto> getCitiesByRegion(Region region);

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
    CityDto updateCity(long id, CityDto cityDto);

    void deleteCityById(long id);

    City mapCityDtoToCity(CityDto cityDto);

    CityDto mapCityToCityDto(City city);
}
