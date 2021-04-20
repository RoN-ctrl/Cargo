package com.cargo.service.impl;

import com.cargo.dto.ParcelDto;
import com.cargo.exceptions.NoSuchParcelFoundException;
import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;
import com.cargo.repository.ParcelRepository;
import com.cargo.service.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    @Override
    public ParcelDto createParcel(ParcelDto parcelDto) {
        Parcel parcel = mapParcelDtoToParcel(parcelDto);
        parcel = parcelRepository.save(parcel);
        log.info("creating parcel={}", parcel);
        return mapParcelToParcelDto(parcel);
    }

    @Override
    public ParcelDto getParcelById(long id) {
        log.info("getting parcel by id={}", id);
        return mapParcelToParcelDto(parcelRepository.findById(id)
                .orElseThrow(() -> new NoSuchParcelFoundException("No parcel with such ID found")));
    }

    @Override
    public List<ParcelDto> getParcelsByStatus(ParcelStatus status) {
        log.info("getting parcels by status={}", status);
        Sort sortByStatus = Sort.by("status");
        List<Parcel> parcels = parcelRepository.findAllByStatus(status, sortByStatus);
        List<ParcelDto> parcelDtos = new ArrayList<>();

        for (Parcel parcel : parcels) {
            parcelDtos.add(mapParcelToParcelDto(parcel));
        }

        return parcelDtos;
    }

    @Override
    public ParcelDto updateParcel(ParcelDto parcelDto) {
        parcelRepository.delete(parcelRepository.findById(parcelDto.getId())
                .orElseThrow(NoSuchParcelFoundException::new));
        Parcel parcel = mapParcelDtoToParcel(parcelDto);
        parcel = parcelRepository.save(parcel);
        log.info("updating parcel={}", parcel);
        return mapParcelToParcelDto(parcel);
    }

    @Override
    public void deleteParcelById(long id) {
        Parcel parcel = parcelRepository.findById(id)
                .orElseThrow(() -> new NoSuchParcelFoundException("No parcel with such ID found"));
        log.info("deleting parcel={}", parcel);
        parcelRepository.delete(parcel);
    }

    @Override
    public ParcelDto mapParcelToParcelDto(Parcel parcel) {
        return ParcelDto.builder()
                .id(parcel.getId())
                .status(parcel.getStatus())
                .fromCity(parcel.getFromCity())
                .toCity(parcel.getToCity())
                .description(parcel.getDescription())
                .volume(parcel.getVolume())
                .distance(parcel.getDistance())
                .price(parcel.getPrice())
                .build();
    }

    @Override
    public Parcel mapParcelDtoToParcel(ParcelDto parcelDto) {
        return Parcel.builder()
                .status(parcelDto.getStatus())
                .account(parcelDto.getAccount())
                .fromCity(parcelDto.getFromCity())
                .toCity(parcelDto.getToCity())
                .description(parcelDto.getDescription())
                .volume(parcelDto.getVolume())
                .distance(parcelDto.getDistance())
                .build();
    }

}
