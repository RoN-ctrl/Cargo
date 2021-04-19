package com.cargo.dto;

import com.cargo.model.Account;
import com.cargo.model.City;
import com.cargo.model.enums.ParcelStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParcelDto {

    private long id;

    private ParcelStatus status;

    @NotNull(message = "Account is mandatory")
    private Account account;

    @NotNull(message = "(from)City is mandatory")
    private City fromCity;

    @NotNull(message = "(to)City is mandatory")
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

    private BigDecimal price;

}
