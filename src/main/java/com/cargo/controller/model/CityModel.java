package com.cargo.controller.model;

import com.cargo.dto.CityDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CityModel extends RepresentationModel<CityModel> {

    @JsonUnwrapped
    private CityDto cityDto;

}
