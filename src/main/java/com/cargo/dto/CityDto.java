package com.cargo.dto;

import com.cargo.model.enums.Region;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDto {

    private long id;
    private String name;
    private Region region;
    private double longitude;
    private double latitude;

}
