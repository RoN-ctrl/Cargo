package com.cargo.service;

import com.cargo.dto.ParcelDto;
import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;

import java.util.List;

public interface ParcelService {
    ParcelDto createParcel(ParcelDto parcelDto);

    ParcelDto getParcelById(long id);

    List<ParcelDto> getParcelsByAccountId(long id);

    List<ParcelDto> getParcelsByStatus(ParcelStatus status);

    ParcelDto updateParcel(ParcelDto parcelDto);

    void deleteParcelById(long id);

    ParcelDto mapParcelToParcelDto(Parcel parcel);
}
