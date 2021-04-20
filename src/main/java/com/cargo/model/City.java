package com.cargo.model;

import com.cargo.annotations.CityNameCheck;
import com.cargo.model.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotBlank(message = "City name is mandatory")
    @CityNameCheck
    private String name;

    @NotNull(message = "City region is mandatory")
    private Region region;

    @NotNull(message = "Longitude is mandatory")
    @Positive(message = "Longitude is not valid")
    private double longitude;

    @NotNull(message = "Latitude is mandatory")
    @Positive(message = "Latitude is not valid")
    private double latitude;

}
