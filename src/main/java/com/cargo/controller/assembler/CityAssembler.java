package com.cargo.controller.assembler;

import com.cargo.controller.CityController;
import com.cargo.controller.model.CityModel;
import com.cargo.dto.CityDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CityAssembler extends RepresentationModelAssemblerSupport<CityDto, CityModel> {

    public CityAssembler() {
        super(CityController.class, CityModel.class);
    }

    @Override
    public CityModel toModel(CityDto entity) {
        CityModel cityModel = new CityModel(entity);

        Link create = linkTo(methodOn(CityController.class).createCity(entity)).withRel("create");
        Link getById = linkTo(methodOn(CityController.class).getCityById(entity.getId())).withRel("get");
        Link getByName = linkTo(methodOn(CityController.class).getCityByName(entity.getName())).withRel("get");
        Link getByRegion = linkTo(methodOn(CityController.class).getCitiesByRegion(entity.getRegion())).withRel("get");
        Link update = linkTo(methodOn(CityController.class).updateCity(entity)).withRel("update");
        Link deleteByID = linkTo(methodOn(CityController.class).deleteCityById(entity.getId())).withRel("delete");

        cityModel.add(create, getById, getByName, getByRegion, update, deleteByID);

        return cityModel;
    }

}
