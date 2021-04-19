package com.cargo.service;

import com.cargo.dto.AccountDto;
import com.cargo.dto.ParcelDto;
import com.cargo.model.enums.ParcelStatus;

import java.util.List;

public interface ParcelService {
    ParcelDto createParcel(ParcelDto parcelDto);

    ParcelDto getParcelById(long id);

    List<ParcelDto> getParcelsByAccount(AccountDto account);

    List<ParcelDto> getParcelsByStatus(ParcelStatus status);

    ParcelDto updateParcel(ParcelDto parcelDto);

    void deleteParcelById(long id);
}
