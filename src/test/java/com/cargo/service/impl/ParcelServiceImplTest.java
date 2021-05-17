package com.cargo.service.impl;

import com.cargo.model.Parcel;
import com.cargo.repository.ParcelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParcelServiceImplTest {

    @InjectMocks
    private ParcelServiceImpl parcelService;

    @Mock
    private ParcelRepository parcelRepository;

//    private Parcel testCreateParcel() {
//        return Parcel.builder()
//                .id()
//                .status()
//                .account()
//                .fromCity()
//                .toCity()
//                .volume()
//                .distance()
//                .build();
//    }

    @Test
    void createParcel() {
    }

    @Test
    void getParcelById() {
    }

    @Test
    void getParcelsByStatus() {
    }

    @Test
    void updateParcel() {
    }

    @Test
    void deleteParcelById() {
    }

    @Test
    void mapParcelToParcelDto() {
    }

    @Test
    void mapParcelDtoToParcel() {
    }
}