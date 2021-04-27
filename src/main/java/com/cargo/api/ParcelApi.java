package com.cargo.api;

import com.cargo.controller.model.ParcelModel;
import com.cargo.dto.ParcelDto;
import com.cargo.model.enums.ParcelStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Parcel management API")
@RequestMapping("/api/v1/parcels")
public interface ParcelApi {

    @ApiOperation("Create parcel")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ParcelModel createParcel(@Valid @RequestBody ParcelDto parcelDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Parcel id")
    })
    @ApiOperation("Get parcel by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    ParcelModel getParcelById(@PathVariable long id);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", paramType = "path", required = true, value = "Parcel status")
    })
    @ApiOperation("Get parcel by status")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<ParcelModel> getParcelsByStatus(@RequestParam(value = "status") ParcelStatus status);

    @ApiOperation("Update parcel")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    ParcelModel updateParcel(@PathVariable long id, @Valid @RequestBody ParcelDto parcelDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Parcel id")
    })
    @ApiOperation("Delete parcel by id")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteParcelById(@PathVariable long id);

}
