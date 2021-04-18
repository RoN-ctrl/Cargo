package com.cargo.api;

import com.cargo.controller.model.CityModel;
import com.cargo.dto.CityDto;
import com.cargo.model.enums.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "City management API")
@RequestMapping("/api/v1/cities")
public interface CityApi {

    @ApiOperation("Create city")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CityModel createCity(@Valid @RequestBody CityDto cityDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "City id")
    })
    @ApiOperation("Get city by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    CityModel getCityById(@PathVariable long id);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "value", required = true, value = "City name")
    })
    @ApiOperation("Get city by name")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CityModel getCityByName(@RequestParam(value = "name") String name);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "City region")
    })
    @ApiOperation("Get cities by region")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/region/{region}")
    List<CityModel> getCitiesByRegion(@PathVariable Region region);

    @ApiOperation("Update city")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    CityModel updateCity(@Valid @RequestBody CityDto cityDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "City id")
    })
    @ApiOperation("Delete city by id")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCityById(@PathVariable long id);
}
