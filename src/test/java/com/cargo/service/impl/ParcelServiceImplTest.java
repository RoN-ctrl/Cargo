package com.cargo.service.impl;

import com.cargo.dto.ParcelDto;
import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;
import com.cargo.repository.ParcelRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.cargo.test.util.TestDataUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParcelServiceImplTest {

    @InjectMocks
    private ParcelServiceImpl parcelService;

    @Mock
    private ParcelRepository parcelRepository;

    @Test
    void createParcel() {
        Parcel parcel = testCreateParcel();
        ParcelDto parcelDto = testCreateParcelDto();
        when(parcelRepository.save(parcel)).thenReturn(parcel);

        ParcelDto testParcelDto = parcelService.createParcel(parcelDto);

        assertThat(testParcelDto, getParcelMatcher(parcel));

    }

    @Test
    void shouldGetParcelById() {
        Parcel parcel = testCreateParcel();
        when(parcelRepository.findById(ID)).thenReturn(Optional.of(parcel));

        ParcelDto parcelDto = parcelService.getParcelById(ID);

        assertThat(parcelDto, getParcelMatcher(parcel));

    }

    @Test
    void shouldGetParcelsByStatus() {
        List<Parcel> parcels = new ArrayList<>();
        Parcel parcel = testCreateParcel();
        parcels.add(parcel);
        when(parcelRepository.findAllByStatus(STATUS)).thenReturn(parcels);

        List<ParcelDto> parcelDtos = parcelService.getParcelsByStatus(STATUS);

        assertThat(parcelDtos.size(), equalTo(parcels.size()));

    }

    @Test
    void shouldUpdateParcel() {
        Parcel parcel = testCreateParcel();
        ParcelDto newParcel = ParcelDto.builder()
                .id(3)
                .status(ParcelStatus.STATUS_PAID)
                .account(testCreateAccount())
                .fromCity(testCreateCity())
                .toCity(testCreateCity())
                .volume(3)
                .distance(700)
                .build();

        when(parcelRepository.findById(ID)).thenReturn(Optional.of(parcel));
        when(parcelRepository.save(ArgumentMatchers.any(Parcel.class)))
                .thenReturn(parcelService.mapParcelDtoToParcel(newParcel));

        ParcelDto parcelDto = parcelService.updateParcel(0, newParcel);

        assertThat(parcelDto, allOf(
                hasProperty("status", equalTo(newParcel.getStatus())),
                hasProperty("fromCity", equalTo(newParcel.getFromCity())),
                hasProperty("toCity", equalTo(newParcel.getToCity())),
                hasProperty("volume", equalTo(newParcel.getVolume())),
                hasProperty("distance", equalTo(newParcel.getDistance()))
        ));

    }

    @Test
    void deleteParcelById() {
        Parcel parcel = testCreateParcel();
        when(parcelRepository.findById(ID)).thenReturn(Optional.of(parcel));

        parcelService.deleteParcelById(ID);

        verify(parcelRepository).delete(parcel);

    }

    @Test
    void shouldReturnParcelDto_whenGivenParcel() {
        Parcel parcel = testCreateParcel();

        ParcelDto parcelDto = parcelService.mapParcelToParcelDto(parcel);

        assertThat(parcelDto, getParcelMatcher(parcel));

    }

    @Test
    void shouldReturnParcel_whenGivenParcelDto() {
        ParcelDto parcelDto = testCreateParcelDto();

        Parcel parcel = parcelService.mapParcelDtoToParcel(parcelDto);

        assertThat(parcel, allOf(
                hasProperty("id", equalTo(parcel.getId())),
                hasProperty("status", equalTo(parcel.getStatus())),
                hasProperty("fromCity", equalTo(parcel.getFromCity())),
                hasProperty("toCity", equalTo(parcel.getToCity())),
                hasProperty("volume", equalTo(parcel.getVolume())),
                hasProperty("distance", equalTo(parcel.getDistance()))
        ));

    }

    private Matcher<ParcelDto> getParcelMatcher(Parcel parcel) {
        return allOf(
                hasProperty("id", equalTo(parcel.getId())),
                hasProperty("status", equalTo(parcel.getStatus())),
                hasProperty("fromCity", equalTo(parcel.getFromCity())),
                hasProperty("toCity", equalTo(parcel.getToCity())),
                hasProperty("volume", equalTo(parcel.getVolume())),
                hasProperty("distance", equalTo(parcel.getDistance()))
        );
    }

}