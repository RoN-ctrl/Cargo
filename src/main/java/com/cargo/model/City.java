package com.cargo.model;

import com.cargo.model.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

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
    //todo @CustomStartsWithUpperCase
    private String name;

    @NotNull(message = "City region is mandatory")
    private Region region;

    @NotNull(message = "Longitude is mandatory")
    @Positive(message = "Longitude is not valid")
    private double longitude;

    @NotNull(message = "Latitude is mandatory")
    @Positive(message = "Latitude is not valid")
    private double latitude;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "toCity")
//    private List<Parcel> parcelsTo;
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fromCity")
//    private List<Parcel> parcelsFrom;

}
