package com.cargo.model;

import com.cargo.model.enums.ParcelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ColumnDefault(value = "STATUS_NEW")
    private ParcelStatus status;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_city_id")
    private City fromCity;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_city_id")
    private City toCity;

    private String description;

    @NotNull(message = "Volume is mandatory")
    @Positive(message = "Volume is not valid")
    @Min(value = 1)
    @Max(value = 10)
    private double volume;

    @NotNull(message = "Distance is mandatory")
    @Positive(message = "Distance is not valid")
    private double distance;

    @Formula(value = "volume * distance * 0.05")
    private BigDecimal price;

}
