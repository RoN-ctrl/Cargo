package com.cargo.service;

import com.cargo.dto.ParcelDto;
import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface ParcelService {
    ParcelDto createParcel(ParcelDto parcelDto);

    ParcelDto getParcelById(long id);

    List<ParcelDto> getParcelsByStatus(ParcelStatus status);

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
    ParcelDto updateParcel(ParcelDto parcelDto);

    void deleteParcelById(long id);

    ParcelDto mapParcelToParcelDto(Parcel parcel);

    Parcel mapParcelDtoToParcel(ParcelDto parcelDto);
}
