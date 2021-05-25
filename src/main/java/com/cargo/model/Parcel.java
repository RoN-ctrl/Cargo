package com.cargo.model;

import com.cargo.model.enums.ParcelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private ParcelStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_city_id")
    private City fromCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_city_id")
    private City toCity;

    private String description;

    private double volume;

    private double distance;

    @Formula(value = "volume * distance * 0.05")
    private BigDecimal price;

}
