package com.cargo.controller;

import com.cargo.api.ParcelApi;
import com.cargo.controller.assembler.ParcelAssembler;
import com.cargo.controller.model.ParcelModel;
import com.cargo.dto.ParcelDto;
import com.cargo.model.enums.ParcelStatus;
import com.cargo.service.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ParcelController implements ParcelApi {

    private final ParcelService parcelService;
    private final ParcelAssembler parcelAssembler;

    @Override
    public ParcelModel createParcel(ParcelDto parcelDto) {
        log.info("controller: createParcel={}", parcelDto);
        ParcelDto parcel = parcelService.createParcel(parcelDto);
        return parcelAssembler.toModel(parcel);
    }

    @Override
    public ParcelModel getParcelById(long id) {
        log.info("controller: getParcelById={}", id);
        ParcelDto parcel = parcelService.getParcelById(id);
        return parcelAssembler.toModel(parcel);
    }

    @Override
    public List<ParcelModel> getParcelsByStatus(ParcelStatus status) {
        log.info("controller: getParcelsByStatus={}", status);
        List<ParcelDto> parcels = parcelService.getParcelsByStatus(status);
        List<ParcelModel> parcelModels = new ArrayList<>();

        for (ParcelDto parcel : parcels) {
            parcelModels.add(parcelAssembler.toModel(parcel));
        }

        return parcelModels;
    }

    @Override
    public ParcelModel updateParcel(ParcelDto parcelDto) {
        log.info("controller: updateParcel={}", parcelDto);
        ParcelDto parcel = parcelService.updateParcel(parcelDto);
        return parcelAssembler.toModel(parcel);
    }

    @Override
    public ResponseEntity<Void> deleteParcelById(long id) {
        log.info("controller: deleteParcelById={}", id);
        parcelService.deleteParcelById(id);
        return ResponseEntity.noContent().build();
    }

}
