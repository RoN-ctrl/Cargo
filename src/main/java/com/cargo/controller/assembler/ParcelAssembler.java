package com.cargo.controller.assembler;

import com.cargo.controller.ParcelController;
import com.cargo.controller.model.ParcelModel;
import com.cargo.dto.ParcelDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ParcelAssembler extends RepresentationModelAssemblerSupport<ParcelDto, ParcelModel> {

    public ParcelAssembler() {
        super(ParcelController.class, ParcelModel.class);
    }

    @Override
    public ParcelModel toModel(ParcelDto entity) {
        ParcelModel parcelModel = new ParcelModel(entity);

        Link create = linkTo(methodOn(ParcelController.class).createParcel(entity)).withRel("create");
        Link getById = linkTo(methodOn(ParcelController.class).getParcelById(entity.getId())).withRel("get");
        Link getByStatus = linkTo(methodOn(ParcelController.class)
                .getParcelsByStatus(entity.getStatus())).withRel("get");
        Link update = linkTo(methodOn(ParcelController.class).updateParcel(entity)).withRel("update");
        Link deleteByID = linkTo(methodOn(ParcelController.class).deleteParcelById(entity.getId())).withRel("delete");

        parcelModel.add(create, getById, getByStatus, update, deleteByID);

        return parcelModel;
    }

}
