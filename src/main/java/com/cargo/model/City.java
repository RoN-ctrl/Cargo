package com.cargo.model;

import com.cargo.model.enums.Region;
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
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotBlank(message = "City name is mandatory")
    //todo @CustomStartsWithUpperCase
    private String name;

    @NotNull(message = "City region is mandatory")
    private Region region;

    @Positive(message = "Longitude is not valid")
    private double longitude;

    @Positive(message = "Latitude is not valid")
    private double latitude;

}
