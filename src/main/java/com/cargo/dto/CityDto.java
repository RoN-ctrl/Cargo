package com.cargo.dto;

import com.cargo.annotations.CityNameCheck;
import com.cargo.model.enums.Region;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDto {

    private long id;

    @NotBlank(message = "City name is mandatory")
    @CityNameCheck
    private String name;

    @NotNull(message = "City region is mandatory")
    private Region region;

    @NotNull(message = "Longitude is mandatory")
    @Positive(message = "Longitude is not valid")
    private double longitude;

    @NotNull(message = "Latitude is mandatory")
    @Positive(message = "Latitude is not valid")
    private double latitude;

}
