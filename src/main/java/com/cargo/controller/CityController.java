package com.cargo.controller;

import com.cargo.api.CityApi;
import com.cargo.controller.assembler.CityAssembler;
import com.cargo.controller.model.CityModel;
import com.cargo.dto.CityDto;
import com.cargo.model.enums.Region;
import com.cargo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CityController implements CityApi {

    private final CityService cityService;
    private final CityAssembler cityAssembler;

    @Override
    public CityModel createCity(CityDto cityDto) {
        log.info("controller: createCity={}", cityDto);
        CityDto city = cityService.createCity(cityDto);
        return cityAssembler.toModel(city);
    }

    @Override
    public CityModel getCityById(long id) {
        log.info("controller: getCitiesById={}", id);
        CityDto city = cityService.getCityById(id);
        return cityAssembler.toModel(city);
    }

    @Override
    public CityModel getCityByName(String name) {
        log.info("controller: getCitiesByName={}", name);
        CityDto city = cityService.getCityByName(name);
        return cityAssembler.toModel(city);
    }

    @Override
    public List<CityModel> getCitiesByRegion(Region region) {
        log.info("controller: getCitiesByRegion={}", region);
        List<CityDto> cities = cityService.getCitiesByRegion(region);
        List<CityModel> cityModels = new ArrayList<>();

        for (CityDto city : cities) {
            cityModels.add(cityAssembler.toModel(city));
        }

        return cityModels;
    }

    @Override
    public CityModel updateCity(CityDto cityDto) {
        log.info("controller: updateCity={}", cityDto);
        CityDto city = cityService.updateCity(cityDto);
        return cityAssembler.toModel(city);
    }

    @Override
    public ResponseEntity<Void> deleteCityById(long id) {
        log.info("controller: deleteCityById={}", id);
        cityService.deleteCityById(id);
        return ResponseEntity.noContent().build();
    }

}
