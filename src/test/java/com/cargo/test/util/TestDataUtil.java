package com.cargo.test.util;

import com.cargo.dto.AccountDto;
import com.cargo.dto.CityDto;
import com.cargo.dto.ParcelDto;
import com.cargo.model.Account;
import com.cargo.model.City;
import com.cargo.model.Parcel;
import com.cargo.model.enums.ParcelStatus;
import com.cargo.model.enums.Region;
import com.cargo.model.enums.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataUtil {

    public static final long ID = 0;

    //account data
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL = "email@ukr.net";
    public static final Role ROLE = Role.ROLE_USER;

    //city data
    public static final String NAME = "Lviv";
    public static final Region REGION = Region.REGION_EUROPE;
    public static final double LONGITUDE = 55.5;
    public static final double LATITUDE = 33.3;

    //parcel data
    public static final ParcelStatus STATUS = ParcelStatus.STATUS_NEW;
    public static final double VOLUME = 5;
    public static final double DISTANCE = 500;

    public static Account testCreateAccount() {
        return Account.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .role(ROLE)
                .build();
    }

    public static AccountDto testCreateAccountDto() {
        return AccountDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .role(ROLE)
                .build();
    }

    public static City testCreateCity() {
        return City.builder()
                .id(ID)
                .name(NAME)
                .region(REGION)
                .longitude(LONGITUDE)
                .latitude(LATITUDE)
                .build();
    }

    public static CityDto testCreateCityDto() {
        return CityDto.builder()
                .id(ID)
                .name(NAME)
                .region(REGION)
                .longitude(LONGITUDE)
                .latitude(LATITUDE)
                .build();
    }

    public static Parcel testCreateParcel() {
        City city = testCreateCity();

        return Parcel.builder()
                .id(ID)
                .status(STATUS)
                .account(testCreateAccount())
                .fromCity(city)
                .toCity(city)
                .volume(VOLUME)
                .distance(DISTANCE)
                .build();
    }

    public static ParcelDto testCreateParcelDto() {
        City city = testCreateCity();

        return ParcelDto.builder()
                .id(ID)
                .status(STATUS)
                .account(testCreateAccount())
                .fromCity(city)
                .toCity(city)
                .volume(VOLUME)
                .distance(DISTANCE)
                .build();
    }

}
